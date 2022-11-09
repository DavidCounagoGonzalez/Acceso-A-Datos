
package xmlwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import javax.xml.stream.XMLStreamException;
import serializacion2.Product;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
 


public class XMLWriter {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException {
        
       FileInputStream fich = new FileInputStream("/home/oracle/DAM/serial2.txt");
       ObjectInputStream inp = new ObjectInputStream (fich);
       
       File borra = new File("/home/oracle/DAM/products.xml");
          borra.delete();
       
       Product prodh;
       while(fich.available()!=0){
            prodh= (Product) inp.readObject();
            System.out.println(prodh.getCodigo()+ " " + prodh.getDescrición()+ " " + prodh.getPrezo());
            
            XMLWriter.jaxbObjectToXML(prodh);
       }
       
       inp.close();
        
    }
    private static void jaxbObjectToXML(Product producto) throws FileNotFoundException, IOException {
      try{
          JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
           
          Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
          
          PrintWriter fich = new PrintWriter(new BufferedWriter(new FileWriter("/home/oracle/DAM/products.xml")));
 
          jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

          jaxbMarshaller.marshal(producto, fich);
          jaxbMarshaller.marshal(producto, System.out);
          
 
      } catch (JAXBException e) {
          System.out.println(e);
      }
  }
    
}


