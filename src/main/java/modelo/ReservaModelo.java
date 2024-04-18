package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;

public class ReservaModelo extends Conector{

	public ArrayList<Reserva> getTodos() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        Conector conector = new Conector();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RESERVAS");
            while (rs.next()) {
                Reserva reserva = new Reserva();
                
                reserva.setId(rs.getInt("ID_RESERVA"));
                reserva.setFecha(rs.getDate("FECHA_RESERVA"));
                reserva.setHora(rs.getString("HORA_RESERVA"));
                reserva.setNumPersonas(rs.getInt("NUM_PERSONAS"));
                reserva.setObservaciones(rs.getString("OBSERVACIONES"));
                reserva.setAlergenos(rs.getString("ALERGENOS"));
                
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
         PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM reserva WHERE id=?");
         pst.setInt(1, id);
         ResultSet rs = pst.executeQuery();

         if (rs.next()) {
             Reserva reserva = new Reserva();

        	 reserva.setId(rs.getInt("Id"));
             reserva.setFecha(rs.getDate("fecha"));
             reserva.setHora(rs.getString("Hora"));
             reserva.setNumPersonas(rs.getInt("Nº Personas"));
             reserva.setAlergenos(rs.getString("Alergenos"));
             reserva.setObservaciones(rs.getString("Observaciones"));
             

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
         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM reserva WHERE id=?");
         pst.setInt(1, id);
         pst.execute();
         return true;
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     }
 }
 
 public int update(Reserva reserva) {
     try {
         PreparedStatement pst = this.conexion.prepareStatement("UPDATE reserva SET id = ?, fecha = ? hora id = ?, numPersonas = ?, alergenos = ?, observaciones = ?");
         
         pst.setInt(1, reserva.getId());
	     pst.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
         pst.setString(3, reserva.getHora());
         pst.setInt(4, reserva.getNumPersonas());
         pst.setString(5, reserva.getAlergenos());
         pst.setString(6, reserva.getObservaciones());

         return pst.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
         return 0;
     }
 }
 
 public void insert(Reserva reserva) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO reserva (id, fecha, hora, numPersonas, alergenos, observaciones) VALUES (?, ?, ?, ?, ?, ?)");
	        
	        pst.setInt(1, reserva.getId());
	        pst.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
	        pst.setString(3, reserva.getHora());
	        pst.setInt(4, reserva.getNumPersonas());
	        pst.setString(5, reserva.getAlergenos());
	        pst.setString(6, reserva.getObservaciones());
	        
	        pst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
