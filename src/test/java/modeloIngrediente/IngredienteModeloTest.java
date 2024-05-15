package modeloIngrediente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Alergeno;

class IngredienteModeloTest {

	@Test
	void testIngrediente() {
		//test insert
		IngredienteModelo im = new IngredienteModelo();
		Ingrediente ingrediente = new Ingrediente();
		
		//set id
		ingrediente.setId(20);
		
		//set nombre
		ingrediente.setNombre("Quesito");
		
		//set alergeno string y transformarlo en Objeto
		String alergenoString = "leche";
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		ingrediente.setAlergeno(alergeno);
		
		//insertar en bbdd
		im.insert(ingrediente);
		
		ArrayList<Ingrediente> ingredientesObtenidos = im.getTodos();
		Ingrediente ingrediente2 = im.get(ingredientesObtenidos.get(0).getId());
		//test update
		ingrediente.setId(9);
		im.update(ingrediente);
		
		//test delete
		im.delete(ingrediente.getId());
	}

}
