package modeloPlato;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Tipo;
import modeloIngrediente.Ingrediente;

class PlatoModeloTest {

	@Test
	void testPlato() {
		//insert plato
		PlatoModelo pm = new PlatoModelo();
		Plato plato = new Plato();
		plato.setId(1);
		plato.setNombre("plato");
		String tipoString = "primero";
		Tipo tipo = Tipo.valueOf(tipoString);
		plato.setTipo(tipo);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		plato.setIngredientes(ingredientes);
		pm.insert(plato);
		
		//update
		plato.setId(2);
		pm.update(plato);
		
		//delete
		pm.delete(plato.getId());
	}

}
