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
                // Obtener el valor del alérgeno como un String desde la base de datos
                String alergenoStr = rs.getString("ALERGENOS");
                
                // Convertir el String a un valor del enum Alergeno
                Alergeno alergeno = Alergeno.valueOf(alergenoStr.toLowerCase());
                
                reserva.setObservaciones(rs.getString("OBSERVACIONES"));
                
                //reserva.setAlergeno( Alergeno.valueOf(rs.getString("ALERGENOS")));
                
                //Asignar el alergeno al ingrediente
                reserva.setAlergeno(alergeno);
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
             // Obtener el valor del alérgeno como un String desde la base de datos
             String alergenoStr = rs.getString("ALERGENOS");
             // Convertir el String a un valor del enum Alergeno
             Alergeno alergeno = Alergeno.valueOf(alergenoStr.toLowerCase());
                
             // Asignar el alergeno al ingrediente
             reserva.setAlergeno(alergeno);
        
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
 
// public int update(Reserva reserva) {
//     try {
//         PreparedStatement pst = this.conexion.prepareStatement("UPDATE RESERVAS SET ID_RESERVA = ?, FECHA_RESERVA = ? ,HORA_RESERVA = ?, numPersonas = ?, alergenos = ?, observaciones = ?");
//         
//         pst.setInt(1, reserva.getId());
//	     pst.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
//         pst.setString(3, reserva.getHora());
//         pst.setInt(4, reserva.getNumPersonas());
//         pst.setString(5, reserva.getAlergeno());
//         pst.setString(6, reserva.getObservaciones());
//
//         return pst.executeUpdate();
//     } catch (SQLException e) {
//         e.printStackTrace();
//         return 0;
//     }
// }
// 
// public void insert(Reserva reserva) {
//	    try {
//	        PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO reserva (id, fecha, hora, numPersonas, alergenos, observaciones) VALUES (?, ?, ?, ?, ?, ?)");
//	        
//	        pst.setInt(1, reserva.getId());
//	        pst.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
//	        pst.setString(3, reserva.getHora());
//	        pst.setInt(4, reserva.getNumPersonas());
//	        pst.setString(5, reserva.getAlergenos());
//	        pst.setString(6, reserva.getObservaciones());
//	        
//	        pst.execute();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
}
