
package serializacion2;

import java.io.Serializable;
import javax.xml.bind.annotation.*;


public class Product implements Serializable{
    
    private String codigo;
    private String descrición;
    private double prezo;

    public Product() {
    }
    
    public Product(String codigo, String descrición, double prezo) {
        this.codigo = codigo;
        this.descrición = descrición;
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrición() {
        return descrición;
    }

    public void setDescrición(String descrición) {
        this.descrición = descrición;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
    
    
    
}
