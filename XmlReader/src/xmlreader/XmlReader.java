
package xmlreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import serializacion2.Product;

public class XmlReader {
    
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JAXBException{
        
        ArrayList<Product> listaProd = null;
        Product productos = new Product();

        XMLInputFactory factor = XMLInputFactory.newInstance();
        XMLEventReader reader = factor.createXMLEventReader(new FileInputStream("/home/oracle/DAM/products.xml"));
        
       while (reader.hasNext()) {
        XMLEvent nextEvent = reader.nextEvent();
         if (nextEvent.isStartElement()) {
        StartElement startElement = nextEvent.asStartElement();
        switch (startElement.getName().getLocalPart()) {
            case "Producto":
                
                Attribute codigo = startElement.getAttributeByName(new QName("codigo"));
                if (codigo != null) {
                    productos.setCodigo(codigo.getValue());
                    System.out.println(codigo.getValue());
                }
                break;
            case "Descrición":
                nextEvent = reader.nextEvent();
                productos.setDescrición(nextEvent.asCharacters().getData());
                System.out.println(nextEvent.asCharacters().getData());
                break;
            case "Prezo":
                nextEvent = reader.nextEvent();
                productos.setPrezo(Double.parseDouble(nextEvent.asCharacters().getData()));
                System.out.println(nextEvent.asCharacters().getData());
//                listaProd.add(productos);
                break;
        }
        
    }
         
}
       /* Falta por saber como recoger el objeto en la lista para poder imprmirla     https://www.baeldung.com/java-stax*/
//        System.out.println(listaProd);
        
    }
    
}
