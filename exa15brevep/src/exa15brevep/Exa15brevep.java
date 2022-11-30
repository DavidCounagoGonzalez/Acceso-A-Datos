
package exa15brevep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.xml.sax.SAXException;

public class Exa15brevep extends Platos{
    
        public static Connection Conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "oracle";
        String password = "oracle";
        String url = driver + host+ porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url,usuario,password);
        return conn;
    }

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException, ParserConfigurationException, SAXException, XMLStreamException {
        Connection conn = Exa15brevep.Conexion();
        String plato = null;
        String auxCodp;
        String auxCodc;
        int grasatotal = 0;
        ArrayList<String> tipo= new ArrayList();
        ArrayList<String> pesos = new ArrayList();
        ArrayList<String> grasas = new ArrayList();
        ArrayList<String> platos = new ArrayList();
        ArrayList<Integer> grasasTotales = new ArrayList();
        ArrayList<String> codigos = new ArrayList();
        
        String compoP1 = ("SELECT * FROM composicion WHERE codp= ? ");
        String verGraxa = ("SELECT * FROM componentes WHERE codc= ?" );
        
        FileInputStream fich = new FileInputStream("/home/oracle/Descargas/platoss");
        ObjectInputStream inp = new ObjectInputStream (fich);
        
        Platos platoObj = null;
        while(fich.available()!=0){
            platoObj = (Platos) inp.readObject();
            if(platoObj==null){
                break;
            }          
        
        PreparedStatement st = conn.prepareStatement(compoP1);
        
        try{

            auxCodp = platoObj.getCodigop();
            st.setString(1, auxCodp);
            java.sql.ResultSet composicion = st.executeQuery();
            
            while(composicion.next()){
                plato = composicion.getString(1);
                tipo.add(composicion.getString(2));
                pesos.add(composicion.getString(3));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        PreparedStatement ps = conn.prepareStatement(verGraxa);
        try{
            for(int i = 0; i<tipo.size(); i++){
                auxCodc = tipo.get(i);
                ps.setString(1, auxCodc);
                java.sql.ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    grasas.add(rs.getString(3));
                    }
                }
        }catch(Exception e){
            System.out.println(e);
        }
           
        
        for(int i = 0; i<grasas.size(); i++){
            int auxPeso = Integer.parseInt(pesos.get(i));
            int auxGrasa = Integer.parseInt(grasas.get(i));
            
            int grasaParcial = (auxPeso/100*auxGrasa);
            
            grasatotal = grasatotal + grasaParcial;
            
        }
        System.out.println("\n"+plato + "\n" + platoObj.getNomep() + "\nGraxaTotal: " +grasatotal);

        platos.add(platoObj.getNomep());
        grasasTotales.add(grasatotal);
        codigos.add(plato);
        
        XMLWriter(codigos, platos, grasasTotales);
        
        grasatotal=0;
        tipo.clear();
        pesos.clear();
        grasas.clear();
    
        }
        
        inp.close();
        conn.close();
    }
    public static void XMLWriter(ArrayList<String> codigos, ArrayList<String> nombres, ArrayList<Integer> grasasT ) throws IOException, XMLStreamException{
        
        File borra = new File("/home/oracle/DAM/platos.xml");
        borra.delete();
        
        XMLOutputFactory factor = XMLOutputFactory.newInstance();
        XMLStreamWriter streamWriter = factor.createXMLStreamWriter(new FileWriter("/home/oracle/DAM/platos.xml"));
        
       streamWriter.writeStartDocument("UTF-8", "1.0");
       streamWriter.writeStartElement("Productos");

       for(int i=0; i<codigos.size(); i++){
            streamWriter.writeStartElement("Producto");
            streamWriter.writeAttribute("codigo", codigos.get(i));
                streamWriter.writeStartElement("NombreP");
                    streamWriter.writeCharacters(nombres.get(i));
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("GrasasTotales");
                    streamWriter.writeCharacters(String.valueOf(grasasT.get(i)));
                streamWriter.writeEndElement();
            streamWriter.writeEndElement();
       }

       streamWriter.writeEndElement();
       streamWriter.writeEndDocument();
       streamWriter.close();
    }
}
