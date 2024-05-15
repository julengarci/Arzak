package modeloPlato;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Tipo;
import modeloIngrediente.Ingrediente;

class PlatoTest {

	@Test
	void testId() {
		Plato plato = new Plato();
		plato.setId(1);
		assertEquals(1, plato.getId());
	}

	@Test
	void testNombre() {
		Plato plato = new Plato();
		plato.setNombre("plato");
		assertEquals("plato", plato.getNombre());
	}

	@Test
	void testTipo() {
		Plato plato = new Plato();
		String tipoString = "primero";
		Tipo tipo = Tipo.valueOf(tipoString);
		plato.setTipo(tipo);
		assertEquals("primero", plato.getTipo().toString());
	}

	@Test
	void testIngredientes() {
		Plato plato = new Plato();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		plato.setIngredientes(ingredientes);
		ArrayList<Ingrediente> ingredientesObtenidos = plato.getIngredientes();
		assertEquals(ingredientes, ingredientesObtenidos);
	}

	@Test
	void testToString() {
		Plato plato = new Plato();
		plato.setId(1);
		plato.setNombre("plato");
		String tipoString = "primero";
		Tipo tipo = Tipo.valueOf(tipoString);
		plato.setTipo(tipo);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		plato.setIngredientes(ingredientes);
		assertEquals("Plato [id=" + 1 + ", nombre=" + "plato" + ", tipo=" + tipo.getNombre().toLowerCase() + ", ingredientes=" + ingredientes + "]", plato.toString());
	}


}
