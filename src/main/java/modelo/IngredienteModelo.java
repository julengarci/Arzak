package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IngredienteModelo extends Conector{

	public ArrayList<Ingrediente> getTodos() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM INGREDIENTES");
            while (rs.next()) {
            	Ingrediente ingrediente = new Ingrediente();
                
            	ingrediente.setId(rs.getInt("ID_INGREDIENTE"));
            	ingrediente.setNombre(rs.getString("NOMBRE"));
            	// Obtener el valor del alérgeno como un String desde la base de datos
                String alergenoStr = rs.getString("ALERGENOS");
                
                // Convertir el String a un valor del enum Alergeno
                Alergeno alergeno = Alergeno.valueOf(alergenoStr.toLowerCase());
                
                // Asignar el alergeno al ingrediente
                ingrediente.setAlergeno(alergeno);
                
            	ingredientes.add(ingrediente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ingredientes;
    }
	
	public Ingrediente get(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM INGREDIENTES WHERE ID_INGREDIENTE=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();

	         if (rs.next()) {
	        	 Ingrediente ingrediente = new Ingrediente();
	                
	             ingrediente.setId(rs.getInt("ID_INGREDIENTE"));
	             ingrediente.setNombre(rs.getString("NOMBRE"));
	             // Obtener el valor del alérgeno como un String desde la base de datos
	             String alergenoStr = rs.getString("ALERGENOS");
	                
	             // Convertir el String a un valor del enum Alergeno
	             Alergeno alergeno = Alergeno.valueOf(alergenoStr.toLowerCase());
	                
	             // Asignar el alergeno al ingrediente
	             ingrediente.setAlergeno(alergeno);
	                
	             return ingrediente;
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	     return null;
	 }
	 
	 public boolean delete(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM INGREDIENTES WHERE ID_INGREDIENTE=?");
	         pst.setInt(1, id);
	         pst.execute();
	         return true;
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	 
	 public int update(Ingrediente ingrediente) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("UPDATE INGREDIENTES SET NOMBRE = ? , ALERGENOS = ? WHERE ID_INGREDIENTE = ?");
	         
	         pst.setInt(3, ingrediente.getId());
	         pst.setString(1, ingrediente.getNombre());
	         
	         // Convertir el valor del enum al String correspondiente
	         String alergenoStr = ingrediente.getAlergeno().toString().toUpperCase();
	         pst.setString(2, alergenoStr);

	         return pst.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	     }
	 }
	 
	 public void insert(Ingrediente ingrediente) {
		 try {
		     PreparedStatement pst = this.conexion.prepareStatement("CALL insert_ingrediente(?,?)");
		        
		     pst.setString(1, ingrediente.getNombre());
		     pst.setString(2, ingrediente.getAlergeno().toString().toUpperCase());
		     
		     pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
