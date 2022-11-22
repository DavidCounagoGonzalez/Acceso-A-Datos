package exa15brevep;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Platos implements Serializable{
   private String codigop;
   private String nomep;
public Platos()
	{
		this("", "");
	}

        public Platos(String codigo, String nome)
	{
		this.codigop = codigo;
		this.nomep = nome;
	}

	public void setCodigop(String code)
	{
		this.codigop = code;
	}
        @XmlAttribute
	public String getCodigop(){
		return codigop;
	}

	public void setNomep(String nome)
	{
		this.nomep = nome;
	}
       public String getNomep()
	{
		return nomep;
	}
       
        public String toString()
	{
		return "codigo plato : " + codigop + "\n" +
                       "nome plato  : " + nomep + "\n";
	}
 
   
}
