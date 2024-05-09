package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlatosMenusModelo extends Conector{

	public void insertPlatosMenus(int idPlato , int idMenu) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("");
			
			pst.setInt(1, idPlato);
			pst.setInt(2, idMenu);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMenusPlatos(int idMenu) {
		
	}
}
