package modeloCliente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
    public void testNombre() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        assertEquals("Juan", cliente.getNombre());
    }
    
    @Test
    public void testTelefono() {
        Cliente cliente = new Cliente();
        cliente.setTelefono("123456789");
        assertEquals("123456789", cliente.getTelefono());
    }
    
    @Test
    public void testEmail() {
        Cliente cliente = new Cliente();
        cliente.setEmail("juan@juan.com");
        assertEquals("juan@juan.com", cliente.getEmail());
    }
    
    @Test
    public void testToString() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setTelefono("123456789");
        cliente.setEmail("juan@juan.com");
        
        assertEquals("Cliente [nombre=Juan, telefono=123456789, email=juan@juan.com]", cliente.toString());
    }
}