
package exa15brevep;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement
public class Menu implements Serializable{
    
    private List<Platos> platos;

    public Menu() {
    }

    public Menu(List<Platos> platos) {
        this.platos = platos;
    }
    @XmlElement
    public List<Platos> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Platos> platos) {
        this.platos = platos;
    } 
       
}
