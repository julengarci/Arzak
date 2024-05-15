package modeloReserva;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modeloCliente.Cliente;
import modeloMenu.Menu;

class ReservaTest {

	@Test
	void testId() {
		Reserva reserva = new Reserva();
		reserva.setId(1);
		assertEquals(1, reserva.getId());
	}


	@Test
	void testFecha() throws ParseException {
		Reserva reserva = new Reserva();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaString = "2024-06-10";
	    Date fecha = sdf.parse(fechaString);
	    reserva.setFecha(fecha);
	    assertEquals(fecha, reserva.getFecha());
	}

	@Test
	void testHora() {
		Reserva reserva = new Reserva();
		reserva.setHora("hora");
		assertEquals("hora", reserva.getHora());
	}

	@Test
	void testNumPersonas() {
		Reserva reserva = new Reserva();
		reserva.setNumPersonas(3);
		assertEquals(3, reserva.getNumPersonas());
	}

	@Test
	void testObservaciones() {
		Reserva reserva = new Reserva();
		reserva.setObservaciones("observaciones");
		assertEquals("observaciones", reserva.getObservaciones());
	}

	@Test
	void testCliente() {
		Reserva reserva = new Reserva();
		Cliente cliente = new Cliente();
		reserva.setCliente(cliente);
		assertEquals(cliente, reserva.getCliente());
	}

	@Test
	void testMenu() {
		Reserva reserva = new Reserva();
		Menu menu = new Menu();
		reserva.setMenu(menu);
		assertEquals(menu, reserva.getMenu());
	}

	@Test
	void testToString() throws ParseException {
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
		reserva.setCliente(cliente);
		
		Menu menu = new Menu();
		reserva.setMenu(menu);
		
		assertEquals("Reserva [id=" + 1 + ", fecha=" + fecha + ", hora=" + "hora" + ", numPersonas=" + 3
				+", observaciones=" + "observaciones" + ", cliente=" + cliente + ", menu="
				+ menu + "]", reserva.toString());
	}

}
