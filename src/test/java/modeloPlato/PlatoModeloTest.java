package modeloPlato;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
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
		
		ArrayList<Plato> platos = pm.getTodos();
		Plato plato2 = pm.get(platos.get(0).getId());
		ArrayList<Ingrediente> ingredientes2 = pm.getIngredientesplato(plato2.getId());
		int id = pm.getUltimoPlato(); 
		
		//update
		plato.setId(2);
		pm.update(plato);
		
		//delete
		pm.delete(plato.getId());
	}

}
