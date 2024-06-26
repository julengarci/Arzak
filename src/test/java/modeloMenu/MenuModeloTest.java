package modeloMenu;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.Alergeno;
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;
import modeloPlato.Plato;

class MenuModeloTest {

	@Test
	void testMenu() throws ParseException {
		//test insert
		MenuModelo mm = new MenuModelo();
		Menu menu = new Menu();
		
		//set id
		menu.setId(1);
		
		//set nombre
		menu.setPrecio(2.5);
		
		//set fechaInicio
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fecha = "2024-06-10";
	    Date fechaInicio = sdf.parse(fecha); // Parse the string date into a Date object
	    menu.setFechaInicio(fechaInicio);
	    assertEquals(fechaInicio, menu.getFechaInicio());
	    
	    //set fechaFin
	    sdf = new SimpleDateFormat("yyyy-MM-dd");
	    fecha = "2024-06-10";
	    Date fechaFin = sdf.parse(fecha); // Parse the string date into a Date object
	    menu.setFechaFin(fechaFin);
	    assertEquals(fechaFin, menu.getFechaFin());
		
		//insertar en bbdd
		mm.insert(menu);
		
		ArrayList<Menu> menus = mm.getTodos();
		Menu menu2 = mm.get(menus.get(0).getId());
		ArrayList<Plato> platos = mm.getPlatosMenu(menus.get(0).getId());
		int id = mm.getUltimoMenu();
		Menu menu3 = mm.getMenuFecha(menus.get(0).getFechaInicio().toString());
		
		//test update
		menu.setId(9);
		mm.update(menu);
		
		//test delete
		mm.delete(menu.getId());
	}

}
