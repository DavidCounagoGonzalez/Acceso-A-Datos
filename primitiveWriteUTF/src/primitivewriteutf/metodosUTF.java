
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
        
        int cont= 0;
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/cadea.txt");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        String cadCopi = dataCad.readUTF();
        
        FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/texto3.txt");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);
        
        
        try{
        while (cont<3){
            // if (dataCad.available()=true){
            dataCad2.writeUTF(cadCopi);
            
            cont ++;
            //} 
        }
        }
        finally{
            if(dataCad!=null){
                dataCad.close();
            }
            if(dataCad2!=null){
                dataCad2.close();
            }
        }
        
    }
}
