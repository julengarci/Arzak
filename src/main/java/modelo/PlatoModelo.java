package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatoModelo extends Conector{

	public ArrayList<Plato> getTodos() {
        ArrayList<Plato> platos = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PLATOS");
            while (rs.next()) {
            	Plato plato = new Plato();
                
            	plato.setId(rs.getInt("ID_PLATOS"));
            	plato.setNombre(rs.getString("NOMBRE"));
            	// Obtener el valor del alérgeno como un String desde la base de datos
                String tipoStr = rs.getString("TIPO");
                
                // Convertir el String a un valor del enum Tipo
                Tipo tipo = Tipo.valueOf(tipoStr.toLowerCase());
                
                //conseguir array de ingredientes
                ArrayList<Ingrediente> ingredientes = getIngredientesplato(plato.getId());
                
                //asignar el array
                plato.setIngredientes(ingredientes);
                
                // Asignar el tipo al plato
                plato.setTipo(tipo);
                
            	platos.add(plato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return platos;
    }
	
	public Plato get(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM PLATOS WHERE ID_PLATOS=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();

	         if (rs.next()) {
	        	 Plato plato = new Plato();
	                
	             plato.setId(rs.getInt("ID_PLATOS"));
	             plato.setNombre(rs.getString("NOMBRE"));
	             // Obtener el valor del alérgeno como un String desde la base de datos
	             String tipoStr = rs.getString("TIPO");
	                
	             // Convertir el String a un valor del enum Alergeno
	             Tipo tipo = Tipo.valueOf(tipoStr.toLowerCase());
	                
	             // Asignar el alergeno al ingrediente
	             plato.setTipo(tipo);
	             
	             return plato;
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	     return null;
	 }
	
	public ArrayList<Ingrediente> getIngredientesplato(int id){
		try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM INGREDIENTES WHERE ID_PLATO=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();
	         ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
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
	         return ingredientes;
		} catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	 }
	 
	 public boolean delete(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM PLATOS WHERE ID_PLATOS=?");
	         pst.setInt(1, id);
	         pst.execute();
	         return true;
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	 
	 public int update(Plato plato) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("CALL update_plato(?,?,?)");
	         
	         pst.setInt(1, plato.getId());
	         pst.setString(2, plato.getNombre());
	         
	         // Convertir el valor del enum al String correspondiente
	         String tipoStr = plato.getTipo().toString().toUpperCase();
	         pst.setString(3, tipoStr);

	         return pst.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	     }
	 }
	 
	 public void insert(Plato plato) {
		 try {
		     PreparedStatement pst = this.conexion.prepareStatement("CALL insert_plato(?,?)");
		     pst.setString(1, plato.getNombre());
		     pst.setString(2, plato.getTipo().toString().toUpperCase());
		     pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
