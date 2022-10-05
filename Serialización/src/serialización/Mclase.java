
package serialización;

import java.io.Serializable;


public class Mclase implements Serializable {
    
    private String nome;
    // private int numero1;
    private transient int numero1;
    private double numero2;

    Mclase(String nome, int numero1, double numero2) {
        super();
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
    
  
}
