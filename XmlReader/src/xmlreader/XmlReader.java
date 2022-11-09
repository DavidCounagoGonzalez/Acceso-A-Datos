
package xmlreader;


import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import serializacion2.Product;

public class XmlReader {
    
    public static void main(String[] args) throws JAXBException {
        
        JAXBContext jc = JAXBContext.newInstance(Product.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Product productos = (Product) unmarshaller.unmarshal(new File("/home/oracle/DAM/products.xml"));

        System.out.println(productos.getCodigo()+ " "+ productos.getDescrición()+" "+ productos.getPrezo());
        
    }
    
}
