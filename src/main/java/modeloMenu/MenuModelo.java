package modeloMenu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modeloCliente.Cliente;
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;
import modeloPlato.Plato;
import modeloPlato.PlatoModelo;
import modeloReserva.Reserva;


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
            	menu.setPrecio(rs.getDouble("PRECIO"));
            	menu.setFechaInicio(rs.getDate("FECHA_INICIO"));
            	menu.setFechaFin(rs.getDate("FECHA_FIN"));
                
            	//conseguir array de ingredientes
                ArrayList<Plato> platos = getPlatosMenu(menu.getId());
                
                //asignar el array
                menu.setPlatos(platos);
            	//introducir los platos
            	
                menus.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return menus;
    }

	public Menu get(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM MENU WHERE ID_MENU=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();

	         if (rs.next()) {
	             Menu menu = new Menu();

	        	 menu.setId(rs.getInt("ID_MENU"));
	        	 menu.setPrecio(rs.getDouble("PRECIO"));
	             menu.setFechaInicio(rs.getDate("FECHA_INICIO"));
	             menu.setFechaFin(rs.getDate("FECHA_FIN"));
	        
	             return menu;
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	     return null;
	 }
	
	public ArrayList<Plato> getPlatosMenu(int id){
		try {
	         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM MENU_PLATOS WHERE ID_MENU=?");
	         pst.setInt(1, id);
	         ResultSet rs = pst.executeQuery();
	         ArrayList<Plato> platos = new ArrayList<Plato>();
	         while (rs.next()) {
	        	 PlatoModelo pm = new PlatoModelo();
	             
	        	 int idPlato = rs.getInt("ID_PLATOS");
	             
	        	 Plato plato = pm.get(idPlato);
	        	 
	        	 plato.setId(idPlato);
	             
	             platos.add(plato);
	             
	         }
	         return platos;
		} catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	     }
	 }
	
	public int getUltimoMenu() {
	    try {
	        // Crear la consulta SQL para obtener el último plato
	        String sql = "SELECT ID_MENU FROM MENU ORDER BY ID_MENU DESC LIMIT 1";
	        
	        // Preparar la consulta SQL
	        PreparedStatement pst = this.conexion.prepareStatement(sql);

	        // Ejecutar la consulta
	        ResultSet rs = pst.executeQuery();

	        // Verificar si se encontraron resultados
	        if (rs.next()) {
	            // Obtener el ID del último plato
	            int id = rs.getInt("ID_MENU");
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
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM MENU WHERE ID_MENU=?");
	         pst.setInt(1, id);
	         pst.execute();
	         return true;
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	
	public int update(Menu menu) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("CALL update_menu(?,?,?,?)");
	         
	         pst.setInt(1, menu.getId());
	         pst.setDouble(2, menu.getPrecio());
		     pst.setDate(3, new java.sql.Date(menu.getFechaInicio().getTime()));
	         pst.setDate(4, new java.sql.Date(menu.getFechaFin().getTime()));

	         return pst.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	     }
	 }
	
	public void insert(Menu menu) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("CALL insert_menu(?, ?, ?);");
	        
	        pst.setDouble(1, menu.getPrecio());
	        pst.setDate(2, new java.sql.Date(menu.getFechaInicio().getTime()));
	        pst.setDate(3, new java.sql.Date(menu.getFechaFin().getTime()));
	        
	        pst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
