
package serialización;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialización implements Serializable{


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
       Mclase wObx = new Mclase ("ola", -7, 2.7E10);
       
       ObjectOutputStream outp = new ObjectOutputStream (new FileOutputStream("/home/dam2a/AD/serial.txt"));
       outp.writeObject(wObx);
       outp.close();
       
       
       Mclase rObx = null;
       
       ObjectInputStream inp = new ObjectInputStream ( new FileInputStream("/home/dam2a/AD/serial.txt"));
       rObx=(Mclase) inp.readObject();
       inp.close();
       
        System.out.println(rObx.getNome());
        System.out.println(rObx.getNumero1());
        System.out.println(rObx.getNumero2());
    }
    
}
