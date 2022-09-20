
package copybytesimaxen2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Métodos {
    
    public static void copyTexto() throws Exception{
        String fich = "/home/dam2a/AD/foto.jpg";
        String fich2="/home/dam2a/AD/foto2.jpg";
        FileInputStream text = new FileInputStream(fich);
        BufferedInputStream text11 = new BufferedInputStream(text);
        
        FileOutputStream text2 = new FileOutputStream(fich2,true);
        BufferedOutputStream text22 = new BufferedOutputStream(text2);
        
        
        int copia=0;
        try{
        while((copia=text.read()) !=-1){
        
        text2.write(copia);
        }
        }
        finally{
            if (text!=null){
                text.close();
            }
            if(text2!=null){
                text2.close();
            }
        }
        System.out.println("Copiado correctamente.");
        
    }
    
    
        
    
}
