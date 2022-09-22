
package primitivewriteutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class metodosUTF {
    
    public static void repCadeas() throws FileNotFoundException, IOException{
        
        String exemplo = "o tempo esta xelido \n";
        
        int cont= 0;
        
        FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/texto3.txt");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);
        
        
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/texto3.txt");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        
        String cadCopi=null;
        File fich = new File("/home/dam2a/AD/texto3.txt");
        
        
        
        try{
        while (cont<3){
            
            System.out.println("escribindo a cadea: o tempo esta xelido");
            
            dataCad2.writeUTF(exemplo);
            
            System.out.println("Tamaño actual: " + dataCad2.size() + " bytes\n");
            
            cont ++;
            
        }
            System.out.println("Tamaño final do ficheiro: " + dataCad2.size() + " bytes\n");
        }
        finally{
            if(dataCad2!=null){
                dataCad2.close();
            }
        }
        try{
        while(dataCad.available()!=0){
            System.out.println("quedan: " + dataCad.available() + " bytes por leer.");
            
            cadCopi = dataCad.readUTF();
            
            System.out.println("lendo a cadea : " + cadCopi);
            
                
        }
            System.out.println("No queda nada por leer.");
        }
        finally{
            if(dataCad!=null){
            dataCad.close();
        }
        }
        
        
        
    }
}
