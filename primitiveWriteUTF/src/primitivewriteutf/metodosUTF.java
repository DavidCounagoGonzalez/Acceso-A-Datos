
package primitivewriteutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class metodosUTF {
    
    public static void repCadeas() throws FileNotFoundException, IOException{
        
        String exemplo = "o tempo está xélido \n";
        
        int cont= 0;
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/texto3.txt");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        
        
        FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/texto3.txt");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);

        
        String cadCopi=null;
        
        
        
        try{
        while (cont<3){
            dataCad2.writeUTF(exemplo);
                       
            cont ++;
            
        } 
        }
        finally{
            if(dataCad2!=null){
                dataCad2.close();
            }
        }
        try{
        while(dataCad.available()!=0){
            cadCopi = dataCad.readUTF();
            
            System.out.println("escribindo a cadea : " + cadCopi);
            
                
        }
        }
        finally{
            if(dataCad!=null){
            dataCad.close();
        }
        }
        
        
        
    }
}
