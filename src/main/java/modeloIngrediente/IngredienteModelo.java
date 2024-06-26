package modeloIngrediente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Alergeno;
import modelo.Conector;

public class IngredienteModelo extends Conector{

	public ArrayList<Ingrediente> getTodos() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT * FROM INGREDIENTES");
            while (rs.next()) {
            	Ingrediente ingrediente = new Ingrediente();
                
            	ingrediente.setId(rs.getInt("ID_INGREDIENTES"));
            	ingrediente.setNombre(rs.getString("NOMBRE"));
            	// Obtener el valor del al�rgeno como un String desde la base de datos
                String alergenoStr = rs.getString("ALERGENOS");
                
                // Convertir el String a un valor del enum Alergeno
                Alergeno alergeno = Alergeno.valueOf(alergenoStr.toLowerCase().replace(" ", "_"));
                
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
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM INGREDIENTES WHERE ID_INGREDIENTES=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();

	         if (rs.next()) {
	        	 Ingrediente ingrediente = new Ingrediente();
	                
	             ingrediente.setId(rs.getInt("ID_INGREDIENTES"));
	             ingrediente.setNombre(rs.getString("NOMBRE"));
	             // Obtener el valor del al�rgeno como un String desde la base de datos
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
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM INGREDIENTES WHERE ID_INGREDIENTES=?");
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
	         PreparedStatement pst = this.conexion.prepareStatement("CALL update_ingrediente(?,?,?);");
	         
	         pst.setInt(1, ingrediente.getId());
	         pst.setString(2, ingrediente.getNombre());
	         
	         // Convertir el valor del enum al String correspondiente
	         String alergenoStr = ingrediente.getAlergeno().toString().toUpperCase();
	         pst.setString(3, alergenoStr);

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
		     pst.setString(2, ingrediente.getAlergeno().getNombre().toString().toUpperCase().replace("_", " "));
		     pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
