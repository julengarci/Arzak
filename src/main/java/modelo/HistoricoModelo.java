package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HistoricoModelo extends Conector{

	public ArrayList<Historico> getTodos() {
        ArrayList<Historico> historicos = new ArrayList<Historico>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM HISTORICO");
            while (rs.next()) {
            	Historico historico = new Historico();
                
            	historico.setMes(rs.getString("MES"));
            	historico.setAño(rs.getString("AÑO"));
            	historico.setNombre(rs.getString("NOMBRE"));
            	historico.setTelefono(rs.getString("TELEFONO"));
            	historico.setVeces(rs.getInt("VECES_VISITADO"));       	
                
                historicos.add(historico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return historicos;
    }
}
