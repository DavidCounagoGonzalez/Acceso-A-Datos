
package xmlwriter;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.stream.XMLStreamException;
import serializacion2.Product;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;



import javax.xml.transform.TransformerException;


 


public class XMLWriter {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, XMLStreamException, TransformerException{
        
        XMLWriter.writeXML();
        
    }
        
    
      
    public static void writeXML() throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException, TransformerException{
       FileInputStream fich = new FileInputStream("/home/oracle/DAM/serial2.txt");
       ObjectInputStream inp = new ObjectInputStream (fich);
       
       File borra = new File("/home/oracle/DAM/products.xml");
          borra.delete();

       XMLOutputFactory factor = XMLOutputFactory.newInstance();
       XMLStreamWriter streamWriter = factor.createXMLStreamWriter(new FileWriter("/home/oracle/DAM/products.xml"));

       streamWriter.writeStartDocument("UTF-8", "1.0");
       streamWriter.writeStartElement("Productos");
       Product prodh;

       while(fich.available()!=0){
            prodh= (Product) inp.readObject();

            System.out.println(prodh.getCodigo()+ " " + prodh.getDescrición()+ " " + prodh.getPrezo());
            streamWriter.writeStartElement("Producto");
            streamWriter.writeAttribute("codigo", prodh.getCodigo());
                streamWriter.writeStartElement("Descrición");
                    streamWriter.writeCharacters(prodh.getDescrición());
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("Prezo");
                    streamWriter.writeCharacters(String.valueOf(prodh.getPrezo()));
                streamWriter.writeEndElement();
            streamWriter.writeEndElement();

       }

       streamWriter.writeEndElement();
       streamWriter.writeEndDocument();
       
       streamWriter.close();
       inp.close();
        
    }
}