
package serializacion2;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement
public class Products implements Serializable{
    
    private List<Product> product;

    public Products() {
    }

    public Products(List<Product> product) {
        this.product = product;
    }
    
    @XmlElement
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
    
    
    
}
