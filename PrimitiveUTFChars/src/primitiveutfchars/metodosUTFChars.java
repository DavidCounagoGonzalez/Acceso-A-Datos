
package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class metodosUTFChars  {
    
    public static void repCadeas () throws FileNotFoundException, IOException{
   String exemplo = "Está en casa";
   String cadCopi = null;
   char caracter = 0;
   
   
           FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/text6.dat");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);
        
        
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/text6.dat");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        
        
            
        System.out.println("writeUTF : Está en casa");
            
        dataCad2.writeUTF(exemplo);
            
        System.out.println("Tamaño actual: " + dataCad2.size() + " bytes\n");
            
        System.out.println("writeChars : Está en casa");
        
        dataCad2.writeChars(exemplo);
        System.out.println("Tamaño actual: " +dataCad2.size()+ " bytes\n");
        
        System.out.println("writeUTF : Está en casa");
            
        dataCad2.writeUTF(exemplo);
            
        System.out.println("Tamaño actual: " + dataCad2.size() + " bytes\n");
        
        dataCad2.close();
        
        try{
        while(dataCad.available()!=0){
            System.out.println("quedan: " + dataCad.available() + " bytes por leer.");
            
            cadCopi = dataCad.readUTF();
            
            System.out.println("lendo a cadea : " + cadCopi);
            
            System.out.println("quedan: " + dataCad.available() + " bytes por leer.");
            
            String conte=null;
            
            for (int x=0; x<exemplo.length(); x++){
            caracter =dataCad.readChar();
            if(conte == null)
            conte = Character.toString(caracter);
            else
            conte = conte + caracter;    
            }
            cadCopi=conte;
            
            System.out.println("lendo a cadea : " + cadCopi);
            
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
