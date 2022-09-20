
package copybytesimaxen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MétodosImx {
    
    public static void copyTexto() throws Exception{
        String fich = "/home/dam2a/AD/foto.jpg";
        String fich2="/home/dam2a/AD/foto2.jpg";
        FileInputStream text = new FileInputStream(fich);
        //Actividad 1 sin el true en el output para que sobreescriba el archivo
        //FileOutputStream text2 = new FileOutputStream(fich2);
            //Cuando se sobreescribe el tamaño del archvio es igual al del original
        //Actividad 2 colocamos el true al out para que añada los datos 
        FileOutputStream text2 = new FileOutputStream(fich2,true);
            //En el caso de tener true no se ve dos veces la imagen pero sí aumenta 
            // por 2 el tamaño de la foto2 .
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
