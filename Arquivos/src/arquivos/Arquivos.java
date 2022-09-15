
package arquivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Arquivos {
    
    public static void eDirectorio (String nombre){
        File dir = new File(nombre);
        
        if(dir.isDirectory()){
            System.out.println("O directorio existe");
        } 
        else {
            System.out.println("O direcorio non existe");
        }
    }
    
    public static void eFicheiro(String nombre){
        File fich = new File (nombre);
        
        if(fich.isFile()){
            System.out.println("O Ficheiro existe");
        }
        else{
            System.out.println("O Ficheiro non existe");
        }
    }
    
    public static void crearDirectorio(String nombre) throws IOException{
        
        Path dir = Paths.get(nombre);
        
        if(!Files.exists(dir)){
           Files.createDirectory(dir);
            System.out.println("Se ha creado un nuevo directorio: "+ nombre);
        }
        else{
            System.out.println("O directorio indicado xa existe.");
        }   
    }
    
    public static void crearFicheiro(String nombre) throws IOException{
       File fich = new File(nombre);
       if(!fich.exists()){
       fich.createNewFile();
        System.out.println("Ficheiro creado: "+ fich);
    }
    else{
           System.out.println("Ficheiro xa existente.");    
        }
    
    }
    
    public static void modoAcceso(String nombre){
        File fich = new File(nombre);
        if(fich.canWrite()){
            System.out.println("Escritura sí");
        }
        else{
            System.out.println("Escritura non");
        }
        if(fich.canRead()){
            System.out.println("Lectura sí");
        }
        else{
            System.out.println("Lectura non");
        }
    }
    
    public static void calculaLonxitude(String nombre){
         File fich = new File(nombre);
         System.out.println("Ten un tamaño de : " +fich.length() + " bytes");
    }
    
    public static void mLectura(String nombre){
        File fich = new File(nombre);
        fich.setReadOnly();
        System.out.println("Cambiado a solo lectura");
    }
    public static void mEscritura(String nombre){
        File fich = new File(nombre);
        fich.setWritable(true);
        System.out.println("Prmitese escritura");
    }
    
    public static void borraFicheiro(String nombre){
        File fich = new File(nombre);
        if(fich.exists()){
            fich.delete();
            System.out.println("Arquivo eliminado.");
        }
        else{
            System.out.println("O arquivo non existe.");
        }
    }
    public static void borraDirectorio(String nombre){
        File dir = new File(nombre);
        if(dir.exists()){
            File[]listFich=dir.listFiles();
            for(int i=0;i<listFich.length;i++){
                if (listFich[i].isFile()){
                    listFich[i].delete();
                    System.out.println("Borrado arquivo "+ listFich[i]);
                }
            }
            dir.delete();
            System.out.println("Directorio eliminado.");
        }
        else{
            System.out.println("O directorio non existe.");
      
        }
       }
    
    public static void recur(String nombre){
        File dir = new File (nombre);
        if (dir.exists()){
            File[]listDir=dir.listFiles();
            for(int i=0;i<listDir.length;i++){
                System.out.println(listDir[i]);
            }
        }
        else{
            System.out.println("Non existe o directorio");
        }
    }
    
    public static void Act1() throws IOException{
        String dir= "/home/dam2a/NetBeansProjects/Arquivos/arquivosdir";
        File direct = new File(dir);
        if(!direct.exists()){
            Arquivos.crearDirectorio(dir);
        }
        else{
            System.out.println("Directorio ya existente");
        }
    }
}
