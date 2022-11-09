
package fichAleatorio;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class MetodosAleatorio {
    
    
    public static void aleatorio() throws FileNotFoundException, IOException{
    String[] cod={"p1","p2","p3"};
    String[] desc={"parafusos","cravos","tachas"};
    int[] prezo = {3,4,5};
    
    File fich = new File ("/home/dam2a/AD/prodAleatorio.txt");
    RandomAccessFile raf = new RandomAccessFile(fich,"rw");
    
    
     
    for(int n=0; n < 3 ; n++){
        String codw = String.format("%3s", cod[n]);
        String descw = String.format("%10s", desc[n]);
        String prezow = String.format("%2s", prezo[n]);
        raf.writeChars(codw);
        raf.writeChars(descw);
        raf.writeChars(prezow);
    }
    
    String cad = null;
    int pos=2;
    int linea= (pos-1)*30;
    
    raf.seek(linea);
    
    for(int x=0;x<3 ; x++){
        char res=raf.readChar();
        if ( x==0)
       cad =Character.toString(res);
        else
        cad = cad+ Character.toString(res);    
    }
        System.out.println(cad);
    
    for(int x=0;x<10 ; x++){
        char res=raf.readChar();
        if ( x==0)
       cad =Character.toString(res);
        else
        cad = cad+ Character.toString(res);    
    }
        System.out.println(cad);
       
    for(int x=0;x<2 ; x++){
        char res=raf.readChar();
        if ( x==0)
       cad =Character.toString(res);
        else
        cad = cad+ Character.toString(res);    
    }
        System.out.println(cad);
    
    raf.close();
    
    
    }
    
}
