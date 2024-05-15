package modeloHistorico;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HistoricoModeloTest {

	@Test
	void testGetTodos() {
		HistoricoModelo hm = new HistoricoModelo();
		ArrayList<Historico> historicos = hm.getTodos();
	}

}
