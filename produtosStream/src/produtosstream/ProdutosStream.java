
package produtosstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProdutosStream {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        Product po1 = new Product ("cod1", "parafusos", 3);
        Product po2 = new Product ("cod2", "cravos", 6);
        Product po3 = new Product (null, null,0);
        
        FileOutputStream cadea2 = new FileOutputStream ("/home/dam2a/AD/produtos.txt");
        BufferedOutputStream cad2 = new BufferedOutputStream(cadea2);
        DataOutputStream dataCad2 = new DataOutputStream(cad2);
        
        
        FileInputStream cadea = new FileInputStream("/home/dam2a/AD/produtos.txt");
        BufferedInputStream cad = new BufferedInputStream(cadea);
        DataInputStream dataCad = new DataInputStream(cad);
        
        
        dataCad2.writeUTF(po1.getCodigo());
        dataCad2.writeUTF(po1.getDescrición());
        dataCad2.writeDouble(po1.getPrezo());
        dataCad2.writeUTF(po2.getCodigo());
        dataCad2.writeUTF(po2.getDescrición());
        dataCad2.writeDouble(po2.getPrezo());
        
        dataCad2.close();
        
        String cod;
        String des;
        Double prez;
        
        System.out.println("Lista de produtos gardados no ficheiro:");
        
        while(dataCad.available()!=0){
            po3.setCodigo(dataCad.readUTF());
            po3.setDescrición(dataCad.readUTF());
            po3.setPrezo(dataCad.readDouble());
            
            System.out.println("" + po3.getCodigo() + " , " + po2.getDescrición() + " , " + po3.getPrezo());
        }
        
        dataCad.close();
        
    }
    
}