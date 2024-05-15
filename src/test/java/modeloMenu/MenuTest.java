package modeloMenu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import modeloPlato.Plato;

class MenuTest {

	@Test
	void testId() {
		Menu menu = new Menu();
		menu.setId(1);
		assertEquals(1, menu.getId());
	}


	@Test
	void testPrecio() {
		Menu menu = new Menu();
		menu.setPrecio(2.5);
		assertEquals(2.5, menu.getPrecio());
	}

	@Test
	void testFechaInicio() throws ParseException {
		Menu menu = new Menu();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fecha = "2024-06-10";
	    Date fechaInicio = sdf.parse(fecha); // Parse the string date into a Date object
	    menu.setFechaInicio(fechaInicio);
	    assertEquals(fechaInicio, menu.getFechaInicio());
	}

	@Test
	void testFechaFin() throws ParseException {
		Menu menu = new Menu();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fecha = "2024-06-10";
	    Date fechaFin = sdf.parse(fecha); // Parse the string date into a Date object
	    menu.setFechaFin(fechaFin);
	    assertEquals(fechaFin, menu.getFechaFin());
	}
	
	@Test
	void testPlatos() {
		Menu menu = new Menu();
		ArrayList<Plato> platos = new ArrayList<Plato>();
		menu.setPlatos(platos);
		assertEquals(platos, menu.getPlatos());
	}

	@Test
	void testToString() throws ParseException {
		Menu menu = new Menu();
		
		menu.setId(1);
		
		menu.setPrecio(2.5);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = "2024-06-10";
		Date fechaInicio = sdf.parse(fecha);
		menu.setFechaInicio(fechaInicio);
		
	    fecha = "2024-06-11";
	    Date fechaFin = sdf.parse(fecha); 
	    menu.setFechaFin(fechaFin);
	    
		ArrayList<Plato> platos = new ArrayList<Plato>();
		menu.setPlatos(platos);
		
		assertEquals("Menu [id=" + 1 + ", precio=" + 2.5 + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", platos=" + platos + "]", menu.toString());
	}

}
