package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteModelo extends Conector{
	
	public ArrayList<Cliente> getTodos() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTES");
            while (rs.next()) {
            	Cliente cliente = new Cliente();
                
            	cliente.setId(rs.getInt("ID_CLIENTE"));
            	cliente.setNombre(rs.getString("NOMBRE_CLIENTE"));
            	
            	cliente.setTelefono(rs.getString("TELEFONO"));
            	
            	cliente.setEmail(rs.getString("EMAIL"));
                
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return clientes;
    }
}
