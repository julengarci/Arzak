package modeloReserva;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modeloCliente.Cliente;
import modeloMenu.Menu;

class ReservaModeloTest {

	@Test
	void testReserva() throws ParseException {
		//test insert
		Reserva reserva = new Reserva();
		reserva.setId(1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaString = "2024-06-10";
	    Date fecha = sdf.parse(fechaString);
	    reserva.setFecha(fecha);
	    
	    reserva.setHora("hora");
	    
	    reserva.setNumPersonas(3);
	    
	    reserva.setObservaciones("observaciones");
	    
	    Cliente cliente = new Cliente();
	    cliente.setTelefono("123456789");
		reserva.setCliente(cliente);
		
		Menu menu = new Menu();
		reserva.setMenu(menu);
		
		ReservaModelo rm = new ReservaModelo();
		
		rm.insert(reserva, cliente.getTelefono());
		
		//test update
		reserva.setId(2);
		rm.update(reserva);
		
		//test delete
		rm.delete(reserva.getId());
	}

}
