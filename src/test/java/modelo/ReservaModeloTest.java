package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloMenu.Menu;
import modeloMenu.MenuModelo;
import modeloReserva.Reserva;
import modeloReserva.ReservaModelo;

class ReservaModeloTest {

	@Test
	void testReservaModelo() throws ParseException {
		
		//test insert
		Reserva reserva = new Reserva();
		reserva.setId(1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaString = "2024-06-10";
	    Date fecha = sdf.parse(fechaString);
	    reserva.setFecha(fecha);
	    
	    reserva.setHora("15:00");
	    
	    reserva.setNumPersonas(3);
	    
	    reserva.setObservaciones("observaciones");
	    
	    ClienteModelo cm = new ClienteModelo();
	    Cliente cliente = cm.get("600112233");
	    reserva.setCliente(cliente);
	    
		MenuModelo mm = new MenuModelo();
		Menu menu = mm.get(mm.getUltimoMenu());
		reserva.setMenu(menu);
		
		modelo.ReservaModelo rm = new modelo.ReservaModelo();
		
		rm.insert(reserva);
		
		ArrayList<Reserva> reservas = rm.getTodos();
		Reserva reserva2 = rm.get(reservas.get(0).getId());
		
		
		//test update
		reserva.setHora("13:00");
		rm.update(reserva);
		
		//test delete
		rm.delete(reserva.getId());
	}

}
