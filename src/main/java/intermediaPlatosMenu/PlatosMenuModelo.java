package intermediaPlatosMenu;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Conector;

public class PlatosMenuModelo extends Conector{

	public void insertPlatosMenu(int idMenu, int idPlatos) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("CALL insert_menu_platos(?,?)");
			
			pst.setInt(1, idMenu);
			pst.setInt(2, idPlatos);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMenuPlatos(int idMenu) {
		
			try {
		         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM MENU_PLATOS WHERE ID_MENU = ?");
		         pst.setInt(1, idMenu);
		         pst.execute();
		     } catch (SQLException e) {
		         e.printStackTrace();
		     }
	}
}

