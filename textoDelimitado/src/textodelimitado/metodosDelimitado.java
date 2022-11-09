
package textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

public class metodosDelimitado {
    
    
    public static void delimitado() throws FileNotFoundException, IOException{
    String[] cod={"p1","p2","p3"};
    String[] desc={"parafusos","cravos","tachas"};
    int[] prezo = {3,4,5};
       
    PrintWriter wrCad = new PrintWriter(new BufferedWriter(new FileWriter("/home/dam2a/AD/prodDelimitado.txt")));
    
    for(int n=0; n < 3 ; n++){
        wrCad.print(cod[n] + "\t");
        wrCad.print(desc[n] + "\t");
        wrCad.println(prezo[n] + "\t");
    }
    wrCad.close();
    
    
    BufferedReader bufCad2 = new BufferedReader( new FileReader("/home/dam2a/AD/prodDelimitado.txt"));
    
    
    while(bufCad2.ready()){
        String recoge;
        recoge = bufCad2.readLine();
        String lista[] = recoge.split("\t");

        String dato = null;
        NumberFormat moneda = NumberFormat.getCurrencyInstance(Locale.GERMANY);

                dato = "Código: \t";
                System.out.println(dato + lista[0]);
            
                dato = "Descrición:\t ";
                System.out.println(dato + lista[1]);
            
                dato = "Prezo:   \t";
                double monetario = Double.parseDouble(lista[2]);
                moneda.format(monetario);
                System.out.println(dato + monetario + " €");
            
        }

//        for( int x = 0 ; x < 3 ; x++){
//
//            if (x == 0){
//                dato = "Código: \t";
//                System.out.println(dato + lista[x]);
//            }
//            else if (x == 1){
//                dato = "Descrición:\t ";
//                System.out.println(dato + lista[x]);
//            }
//            else if (x == 2){
//                dato = "Prezo:   \t";
//                double monetario = Double.parseDouble(lista[x]);
//                moneda.format(monetario);
//                System.out.println(dato + monetario + " €");
//            }
//        }
    
        
    bufCad2.close();
    } 
}
