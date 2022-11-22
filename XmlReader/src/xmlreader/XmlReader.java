
package xmlreader;


import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import serializacion2.Products;
import serializacion2.Product;

public class XmlReader {
    
    public static void main(String[] args){
        
        try{
            File fichero = new File("/home/oracle/DAM/products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Products productos = (Products)jaxbUnmarshaller.unmarshal(fichero);
            
            List<Product> lista = productos.getProduct();
            for (Product prod:lista){
                System.out.println(prod.getCodigo()+ " " + prod.getDescrición() + " " + prod.getPrezo());
            }
            
        }catch(JAXBException e){
            System.out.println(e);
        }
        
    }
    
}
