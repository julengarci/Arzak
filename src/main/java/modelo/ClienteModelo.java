package modelo;

import java.sql.PreparedStatement;
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
	
	public Cliente get(String telefono) {
		
		Conector conector = new Conector();
		
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM CLIENTES WHERE TELEFONO=?");
	         pst.setString(1, telefono);
	         ResultSet rs = pst.executeQuery();

	         if (rs.next()) {
	             Cliente cliente = new Cliente();

	             cliente.setNombre(rs.getString("NOMBRE_CLIENTE"));
	             cliente.setTelefono(rs.getString("TELEFONO"));
	             cliente.setEmail(rs.getString("EMAIL"));
	             
	             return cliente;
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	     return null;
	 }
	 
	 public boolean delete(String telefono) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM CLIENTES WHERE TELEFONO=?");
	         pst.setString(1, telefono);
	         pst.execute();
	         return true;
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	 
	 public int update(Cliente cliente) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("CALL update_cliente(?,?,?)");
	         
	         pst.setString(1, cliente.getNombre());
	         pst.setString(2, cliente.getTelefono());
	         pst.setString(3, cliente.getEmail());

	         return pst.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	     }
	 }
	 
	 public void insert(Cliente cliente) {
		 try {
		     PreparedStatement pst = this.conexion.prepareStatement("CALL insert_cliente(?, ?, ?)");
		     
		     pst.setString(1, cliente.getNombre());
		     pst.setString(2, cliente.getTelefono());
		     pst.setString(3, cliente.getEmail());
		     
		     pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
