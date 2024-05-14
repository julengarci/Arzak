package modeloCliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;



class ClienteModeloTest {

	@Test
    void testGetTodos() throws SQLException {
        // Mock de la conexión y los objetos relacionados
        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Configuración de la simulación del query
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(anyString())).thenReturn(resultSetMock);

        // Configuración de los datos de prueba
        when(resultSetMock.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString("NOMBRE_CLIENTE")).thenReturn("Nombre1").thenReturn("Nombre2");
        when(resultSetMock.getString("TELEFONO")).thenReturn("123456789").thenReturn("987654321");
        when(resultSetMock.getString("EMAIL")).thenReturn("email1@example.com").thenReturn("email2@example.com");

        // Creación del objeto ClienteModelo con el mock de la conexión
        ClienteModelo clienteModelo = new ClienteModelo();
        clienteModelo.setConexion(connectionMock);

        // Ejecución del método a probar
        ArrayList<Cliente> clientes = clienteModelo.getTodos();

        // Verificación de los resultados esperados
        assertEquals(2, clientes.size());
        
        //Creamos un cliente de prueba con los mismos datos del primer cliente creado
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Nombre1");
        cliente1.setTelefono("123456789");
        cliente1.setEmail("email1@example.com");
        
        //comprobamos si los datos del cliente uno coinciden con los datos del primer cliente de la Arraylist, en este caso el 0
        assertEquals("Nombre1", clientes.get(0).getNombre());
        assertEquals("123456789", clientes.get(0).getTelefono());
        assertEquals("email1@example.com", clientes.get(0).getEmail());

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Nombre2");
        cliente2.setTelefono("987654321");
        cliente2.setEmail("email2@example.com");
        assertEquals("Nombre2", clientes.get(1).getNombre());
        assertEquals("987654321", clientes.get(1).getTelefono());
        assertEquals("email2@example.com", clientes.get(1).getEmail());
    }

	 @Test
	    void testGet() throws SQLException {
	        // Mock de la conexión y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);
	        ResultSet resultSetMock = mock(ResultSet.class);

	        // Configuración de la simulación del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
	        when(statementMock.executeQuery()).thenReturn(resultSetMock);

	        // Configuración de los datos de prueba
	        when(resultSetMock.next()).thenReturn(true);
	        when(resultSetMock.getString("NOMBRE_CLIENTE")).thenReturn("Nombre1");
	        when(resultSetMock.getString("TELEFONO")).thenReturn("123456789");
	        when(resultSetMock.getString("EMAIL")).thenReturn("email1@example.com");

	        // Creación del objeto ClienteModelo con el mock de la conexión
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecución del método a probar
	        Cliente cliente = clienteModelo.get("123456789");

	        // Verificación de los resultados esperados
	        assertEquals("Nombre1", cliente.getNombre());
	        assertEquals("123456789", cliente.getTelefono());
	        assertEquals("email1@example.com", cliente.getEmail());
	    }
	 
	 @Test
	    void testDelete() throws SQLException {
	        // Mock de la conexión y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuración de la simulación del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Creación del objeto ClienteModelo con el mock de la conexión
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecución del método a probar
	        boolean resultado = clienteModelo.delete("123456789");

	        // Verificación de los resultados esperados
	        assertTrue(resultado);
	        verify(statementMock).execute(); // Verifica que se llame al método execute del PreparedStatement
	    }
	 
	 @Test
	    void testUpdate() throws SQLException {
	        // Mock de la conexión y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuración de la simulación del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
	        when(statementMock.executeUpdate()).thenReturn(1); // Se simula que se actualiza una fila

	        // Creación del objeto ClienteModelo con el mock de la conexión
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Creación de un cliente de prueba
	        Cliente cliente = new Cliente();
	        cliente.setNombre("NuevoNombre");
	        cliente.setTelefono("123456789");
	        cliente.setEmail("nuevoemail@example.com");

	        // Ejecución del método a probar
	        int resultado = clienteModelo.update(cliente);

	        // Verificación de los resultados esperados
	        assertEquals(1, resultado); // Se espera que se haya actualizado una fila
	        verify(statementMock).executeUpdate(); // Verifica que se llame al método executeUpdate del PreparedStatement
	    }
	 
	 @Test
	    void testInsert() throws SQLException {
	        // Mock de la conexión y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuración de la simulación del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Creación del objeto ClienteModelo con el mock de la conexión
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Creación de un cliente de prueba
	        Cliente cliente = new Cliente();
	        cliente.setNombre("NuevoNombre");
	        cliente.setTelefono("123456789");
	        cliente.setEmail("nuevoemail@example.com");

	        // Ejecución del método a probar
	        clienteModelo.insert(cliente);

	        // Verificación de los resultados esperados
	        verify(statementMock).execute(); // Verifica que se llame al método execute del PreparedStatement
	    }
	 
	 @Test
	    void testCheckNumeroDisponible() throws SQLException {
	        // Mock de la conexión y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);
	        ResultSet resultSetMock = mock(ResultSet.class);

	        // Configuración de la simulación del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Configuración de los datos de prueba
	        when(statementMock.executeQuery()).thenReturn(resultSetMock);
	        when(resultSetMock.next()).thenReturn(false); // Simula que no se encontraron resultados

	        // Creación del objeto ClienteModelo con el mock de la conexión
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecución del método a probar
	        boolean resultado = clienteModelo.checkNumeroDisponible("123456789");

	        // Verificación de los resultados esperados
	        assertTrue(resultado); // Se espera que el número esté disponible
	    }
	 
	 @Test
	    void testCheckInt() {
	        // Creación del objeto ClienteModelo
	        ClienteModelo clienteModelo = new ClienteModelo();

	        // Ejecución del método a probar
	        boolean resultado1 = clienteModelo.checkInt("123456"); // Número válido
	        boolean resultado2 = clienteModelo.checkInt("abc123"); // Número inválido

	        // Verificación de los resultados esperados
	        assertTrue(resultado1); // Se espera que sea un número válido
	        assertFalse(resultado2); // Se espera que no sea un número válido
	    }

}