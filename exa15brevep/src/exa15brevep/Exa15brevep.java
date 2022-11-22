
package exa15brevep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.parsers.*;
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

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
        Connection conn = Exa15brevep.Conexion();
        String plato = null;
        String auxCodp;
        String auxCodc;
        ArrayList<String> tipo= new ArrayList();
        ArrayList<String> pesos = new ArrayList();
        ArrayList<String> grasas = new ArrayList();
        ArrayList<Platos> platos = new ArrayList();
        
        String compoP1 = ("SELECT * FROM composicion WHERE codp= ? ");
        String verGraxa = ("SELECT * FROM componentes WHERE codc= ?" );
        
        FileInputStream fich = new FileInputStream("/home/oracle/Descargas/platoss");
        ObjectInputStream inp = new ObjectInputStream (fich);
        
        Platos platoObj;
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
           
        int grasatotal = 0;
        for(int i = 0; i<grasas.size(); i++){
            int auxPeso = Integer.parseInt(pesos.get(i));
            int auxGrasa = Integer.parseInt(grasas.get(i));
            
            int grasaParcial = (auxPeso/100*auxGrasa);
            
            grasatotal = grasatotal + grasaParcial;
            
        }
        System.out.println("\n"+plato + "\n" + platoObj.getNomep() + "\nGraxaTotal: " +grasatotal);
        
        platos.add(platoObj);
        
        tipo.clear();
        pesos.clear();
        grasas.clear();
    
        }
        
        Menu menu = new Menu(platos);
        
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
            Marshaller marshal = jaxbContext.createMarshaller();
            File fxml = new File("/home/oracle/DAM/platos.xml");
            
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshal.marshal(menu, fxml);
            marshal.marshal(menu, System.out);
           
        }catch(Exception e){
            System.out.println(e);
        }
        
        inp.close();
        conn.close();
    }
}
