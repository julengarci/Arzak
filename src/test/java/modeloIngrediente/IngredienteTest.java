package modeloIngrediente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Alergeno;

class IngredienteTest {

	@Test
	void testId() {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setId(1);
		assertEquals(1, ingrediente.getId());
	}


	@Test
	void testNombre() {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNombre("Quesito");
		assertEquals("Quesito", ingrediente.getNombre());
	}

	@Test
	void testAlergeno() {
		Ingrediente ingrediente = new Ingrediente();
		String alergenoString = "ninguno";
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		ingrediente.setAlergeno(alergeno);
		assertEquals("ninguno", ingrediente.getAlergeno().toString());
	}

	@Test
	void testToString() {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setId(1);
		ingrediente.setNombre("Quesito");
		String alergenoString = "ninguno";
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		ingrediente.setAlergeno(alergeno);
		assertEquals("Ingrediente [id=" + 1 + ", nombre=" + "Quesito" + ", alergeno=" + "ninguno" + "]", ingrediente.toString());
	}

}
