package intermediaIngredientePlatos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IngredientesPlatosModeloTest {

	@Test
	void testInsertIngredientesPlatos() {
		IngredientesPlatosModelo ipm = new IngredientesPlatosModelo();
		ipm.insertIngredientesPlatos(1, 23);
	}

	@Test
	void testDeletePlatosIngredientes() {
		IngredientesPlatosModelo ipm = new IngredientesPlatosModelo();
		ipm.deletePlatosIngredientes(1);
	}

}
