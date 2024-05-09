package modeloMenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;


public class MenuModelo extends Conector {

	public ArrayList<Menu> getTodos() {
		ArrayList<Menu> menus = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MENU");
            while (rs.next()) {
            	Menu menu = new Menu();
                
            	menu.setId(rs.getInt("ID_MENU"));
            	menu.setPrecio(rs.getDouble("PREECIO"));
            	menu.setFechaInicio(rs.getDate("FECHA_INICIO"));
            	menu.setFechaFin(rs.getDate("FECHA_FIN"));
                
            	//introducir los platos
            	
                menus.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return menus;
    }

}
