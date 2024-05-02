package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredientesPlatosModelo extends Conector{

	public void insertIngredientesPlatos(int idIngrediente , int idPlato) {
		try {
		     PreparedStatement pst = this.conexion.prepareStatement("CALL insert_platos_ingredientes(?,?)");
		        
		     pst.setInt(1, idIngrediente);
		     pst.setInt(2, idPlato);
		     pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
}
