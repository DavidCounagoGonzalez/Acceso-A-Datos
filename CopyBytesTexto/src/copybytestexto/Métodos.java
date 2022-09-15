
package copybytestexto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Métodos {
    
    public static void copyTexto() throws Exception{
        String fich = "/home/dam2a/AD/texto1.txt";
        String fich2="/home/dam2a/AD/texto2.txt";
        FileInputStream text = new FileInputStream(fich);
        //Actividad 1 sin el true en el output para que sobreescriba
        //FileOutputStream text2 = new FileOutputStream(fich2);
        //Actividad 2 colocamos el true al out para que añada los datos 
        FileOutputStream text2 = new FileOutputStream(fich2,true);
        
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
