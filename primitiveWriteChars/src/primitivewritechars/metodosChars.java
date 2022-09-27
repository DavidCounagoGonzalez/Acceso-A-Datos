
package primitivewritechars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class metodosChars {
    
    public static void repCadeas() throws FileNotFoundException, IOException{
        
        String exemplo = "o tempo esta xelido";
        
        int cont= 0;
        
        
        FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/text5.txt");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);
        
        
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/text5.txt");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        
        char cadCopi = 0;
        String ora = null;
        char lista[] = null;
        
        
        
        try{
        while (cont<2){
            
            System.out.println("escribindo a cadea: o tempo esta xelido");
            
            dataCad2.writeChars(exemplo);
            System.out.println("Lonxitude da cadea: " + exemplo.length() + " caracteres");
            
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
            
            ora= null;
            
            for (int x=0; x<exemplo.length(); x++){
            cadCopi =dataCad.readChar();
            if (ora == null)
                ora=Character.toString(cadCopi);
            else
            ora = ora + cadCopi;
            }
            
            System.out.println("lendo a cadea : " + ora);
            
            System.out.println("quedan: " + dataCad.available() + " bytes por leer.");
                    
        }
        }
        finally{
            if(dataCad!=null){
            dataCad.close();
        }
        }
        
    }
}
