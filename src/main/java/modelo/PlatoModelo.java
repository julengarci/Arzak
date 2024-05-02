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
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM PLATOS_INGREDIENTES WHERE ID_PLATOS=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();
	         ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	         while (rs.next()) {
	        	 IngredienteModelo im = new IngredienteModelo();
	             
	        	 int idIngrediente = rs.getInt("ID_INGREDIENTES");
	             
	        	 Ingrediente ingrediente = im.get(idIngrediente);
	        	 
	        	 ingrediente.setId(idIngrediente);
	             
	             ingredientes.add(ingrediente);
	         }
	         return ingredientes;
		} catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	 }
	
	public int getUltimoPlato() {
	    try {
	        // Crear la consulta SQL para obtener el último plato
	        String sql = "SELECT ID_PLATOS FROM PLATOS ORDER BY ID_PLATOS DESC LIMIT 1";
	        
	        // Preparar la consulta SQL
	        PreparedStatement pst = this.conexion.prepareStatement(sql);

	        // Ejecutar la consulta
	        ResultSet rs = pst.executeQuery();

	        // Verificar si se encontraron resultados
	        if (rs.next()) {
	            // Obtener el ID del último plato
	            int id = rs.getInt("ID_PLATOS");
	            return id;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    // En caso de error o si no se encuentra ningún plato, retornar -1 o algún valor indicativo de error
	    return -1;
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
