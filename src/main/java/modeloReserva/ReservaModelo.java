package modeloReserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;
import modeloCliente.Cliente;
import modeloMenu.Menu;

public class ReservaModelo extends Conector{

	public ArrayList<Reserva> getTodos() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RESERVAS JOIN MENU ON RESERVAS.ID_MENU = MENU.ID_MENU");
            while (rs.next()) {
                Reserva reserva = new Reserva();
                
                reserva.setId(rs.getInt("ID_RESERVA"));
                reserva.setFecha(rs.getDate("FECHA_RESERVA"));
                reserva.setHora(rs.getString("HORA_RESERVA"));
                reserva.setNumPersonas(rs.getInt("NUM_PERSONAS"));
                reserva.setObservaciones(rs.getString("OBSERVACIONES"));
                
                Menu menu = new Menu();
                menu.setId(rs.getInt("ID_MENU"));
                menu.setPrecio(rs.getDouble("PRECIO"));
                reserva.setMenu(menu);
                
                Cliente cliente = new Cliente();
                cliente.setTelefono(rs.getString("TELEFONO_CLIENTE"));
                reserva.setCliente(cliente);
                
                reservas.add(reserva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reservas;
    }
 
 public Reserva get(int id) {
     try {
         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM RESERVAS WHERE ID_RESERVA=?");
         pst.setInt(1, id);
         ResultSet rs = pst.executeQuery();

         if (rs.next()) {
             Reserva reserva = new Reserva();

        	 reserva.setId(rs.getInt("ID_RESERVA"));
        	 reserva.setHora(rs.getString("HORA_RESERVA"));
             reserva.setFecha(rs.getDate("FECHA_RESERVA"));
             reserva.setNumPersonas(rs.getInt("NUM_PERSONAS"));
             reserva.setObservaciones(rs.getString("OBSERVACIONES"));
             Cliente cliente = new Cliente();
             cliente.setTelefono(rs.getString("TELEFONO_CLIENTE"));
             reserva.setCliente(cliente);
        
             return reserva;
         }
     } catch (SQLException e) {
         e.printStackTrace();
         return null;
     }
     return null;
 }
 
 public boolean delete(int id) {
     try {
         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM RESERVAS WHERE ID_RESERVA=?");
         pst.setInt(1, id);
         pst.execute();
         return true;
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     }
 }

 
 public boolean update(Reserva reserva) {
     try {
         PreparedStatement pst = this.conexion.prepareStatement("CALL update_reserva(?,?,?,?,?,?,?)");
         
         pst.setInt(1, reserva.getId());
         pst.setString(2, reserva.getHora());
	     pst.setDate(3, new java.sql.Date(reserva.getFecha().getTime()));
         pst.setInt(4, reserva.getNumPersonas());

         pst.setString(5, reserva.getObservaciones());
         pst.setString(6, reserva.getCliente().getTelefono());
         pst.setInt(7, reserva.getMenu().getId());

         pst.executeUpdate();
     } catch (SQLException e) {
    	 if (e.getMessage().equalsIgnoreCase("No se pueden agregar más de 50 comensales para esta hora")) {
				return false;
			}
     }
     return true;
 }
 
 public boolean insert(Reserva reserva, String telefono) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("CALL insert_reserva(?, ?, ?, ?, ?, ?);");
	        
	        pst.setString(1, reserva.getHora());
	        pst.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
	        pst.setInt(3, reserva.getNumPersonas());
	        pst.setString(4, reserva.getObservaciones());
	        pst.setString(5, telefono);
	        pst.setInt(6, reserva.getMenu().getId());
	        
	        pst.execute();
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (e.getMessage().equalsIgnoreCase("No se pueden agregar más de 50 comensales para esta hora")) {
				return false;
			}
	    }
		return true;
	}

}
