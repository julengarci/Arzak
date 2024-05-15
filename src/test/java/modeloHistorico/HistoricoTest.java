package modeloHistorico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HistoricoTest {

	@Test
	void testMes() {
		Historico historico = new Historico();
		historico.setMes("3");
		assertEquals("3", historico.getMes());
	}

	@Test
	void testAño() {
		Historico historico = new Historico();
		historico.setAño("2024");
		assertEquals("2024", historico.getAño());
	}

	@Test
	void testNombre() {
		Historico historico = new Historico();
		historico.setNombre("nombre");
		assertEquals("nombre", historico.getNombre());
	}

	@Test
	void testTelefono() {
		Historico historico = new Historico();
		historico.setTelefono("123456789");
		assertEquals("123456789", historico.getTelefono());
	}

	@Test
	void testVeces() {
		Historico historico = new Historico();
		historico.setVeces(3);
		assertEquals(3, historico.getVeces());
	}

	@Test
	void testToString() {
		Historico historico = new Historico();
		
		historico.setMes("3");
	    historico.setAño("2024");
	    historico.setNombre("nombre");
	    historico.setTelefono("123456789");
	    historico.setVeces(3);
	    
	    assertEquals("Historico [mes=" + "3" + ", año=" + "2024" + ", nombre=" + "nombre" + ", telefono=" + "123456789" + ", veces="
				+ 3 + "]", historico.toString());
	}

}
