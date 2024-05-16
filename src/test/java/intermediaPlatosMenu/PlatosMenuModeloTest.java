package intermediaPlatosMenu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlatosMenuModeloTest {

	@Test
	void testInsertPlatosMenu() {
		PlatosMenuModelo pmm = new PlatosMenuModelo();
		pmm.insertPlatosMenu(1, 1);
	}

	@Test
	void testDeleteMenuPlatos() {
		PlatosMenuModelo pmm = new PlatosMenuModelo();
		pmm.deleteMenuPlatos(1);
	}

}
