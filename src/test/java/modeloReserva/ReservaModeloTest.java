package modeloReserva;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.catalina.mbeans.NamingResourcesMBean;
import org.junit.jupiter.api.Test;

import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloMenu.Menu;
import modeloMenu.MenuModelo;

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
	    
	    reserva.setHora("15:00");
	    
	    reserva.setNumPersonas(3);
	    
	    reserva.setObservaciones("observaciones");
	    
	    ClienteModelo cm = new ClienteModelo();
	    Cliente cliente = cm.get("123456789");
	    reserva.setCliente(cliente);
	    
		MenuModelo mm = new MenuModelo();
		Menu menu = mm.get(mm.getUltimoMenu());
		reserva.setMenu(menu);
		
		ReservaModelo rm = new ReservaModelo();
		
		rm.insert(reserva, cliente.getTelefono());
		
		ArrayList<Reserva> reservas = rm.getTodos();
		Reserva reserva2 = rm.get(reservas.get(0).getId());
		
		
		//test update
		reserva.setHora("13:00");
		rm.update(reserva);
		
		//test delete
		rm.delete(reserva.getId());
	}

}
