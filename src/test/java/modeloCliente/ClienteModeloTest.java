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
        // Mock de la conexi�n y los objetos relacionados
        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Configuraci�n de la simulaci�n del query
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(anyString())).thenReturn(resultSetMock);

        // Configuraci�n de los datos de prueba
        when(resultSetMock.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString("NOMBRE_CLIENTE")).thenReturn("Nombre1").thenReturn("Nombre2");
        when(resultSetMock.getString("TELEFONO")).thenReturn("123456789").thenReturn("987654321");
        when(resultSetMock.getString("EMAIL")).thenReturn("email1@example.com").thenReturn("email2@example.com");

        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
        ClienteModelo clienteModelo = new ClienteModelo();
        clienteModelo.setConexion(connectionMock);

        // Ejecuci�n del m�todo a probar
        ArrayList<Cliente> clientes = clienteModelo.getTodos();

        // Verificaci�n de los resultados esperados
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
	        // Mock de la conexi�n y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);
	        ResultSet resultSetMock = mock(ResultSet.class);

	        // Configuraci�n de la simulaci�n del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
	        when(statementMock.executeQuery()).thenReturn(resultSetMock);

	        // Configuraci�n de los datos de prueba
	        when(resultSetMock.next()).thenReturn(true);
	        when(resultSetMock.getString("NOMBRE_CLIENTE")).thenReturn("Nombre1");
	        when(resultSetMock.getString("TELEFONO")).thenReturn("123456789");
	        when(resultSetMock.getString("EMAIL")).thenReturn("email1@example.com");

	        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecuci�n del m�todo a probar
	        Cliente cliente = clienteModelo.get("123456789");

	        // Verificaci�n de los resultados esperados
	        assertEquals("Nombre1", cliente.getNombre());
	        assertEquals("123456789", cliente.getTelefono());
	        assertEquals("email1@example.com", cliente.getEmail());
	    }
	 
	 @Test
	    void testDelete() throws SQLException {
	        // Mock de la conexi�n y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuraci�n de la simulaci�n del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecuci�n del m�todo a probar
	        boolean resultado = clienteModelo.delete("123456789");

	        // Verificaci�n de los resultados esperados
	        assertTrue(resultado);
	        verify(statementMock).execute(); // Verifica que se llame al m�todo execute del PreparedStatement
	    }
	 
	 @Test
	    void testUpdate() throws SQLException {
	        // Mock de la conexi�n y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuraci�n de la simulaci�n del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
	        when(statementMock.executeUpdate()).thenReturn(1); // Se simula que se actualiza una fila

	        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Creaci�n de un cliente de prueba
	        Cliente cliente = new Cliente();
	        cliente.setNombre("NuevoNombre");
	        cliente.setTelefono("123456789");
	        cliente.setEmail("nuevoemail@example.com");

	        // Ejecuci�n del m�todo a probar
	        int resultado = clienteModelo.update(cliente);

	        // Verificaci�n de los resultados esperados
	        assertEquals(1, resultado); // Se espera que se haya actualizado una fila
	        verify(statementMock).executeUpdate(); // Verifica que se llame al m�todo executeUpdate del PreparedStatement
	    }
	 
	 @Test
	    void testInsert() throws SQLException {
	        // Mock de la conexi�n y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);

	        // Configuraci�n de la simulaci�n del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Creaci�n de un cliente de prueba
	        Cliente cliente = new Cliente();
	        cliente.setNombre("NuevoNombre");
	        cliente.setTelefono("123456789");
	        cliente.setEmail("nuevoemail@example.com");

	        // Ejecuci�n del m�todo a probar
	        clienteModelo.insert(cliente);

	        // Verificaci�n de los resultados esperados
	        verify(statementMock).execute(); // Verifica que se llame al m�todo execute del PreparedStatement
	    }
	 
	 @Test
	    void testCheckNumeroDisponible() throws SQLException {
	        // Mock de la conexi�n y los objetos relacionados
	        Connection connectionMock = mock(Connection.class);
	        PreparedStatement statementMock = mock(PreparedStatement.class);
	        ResultSet resultSetMock = mock(ResultSet.class);

	        // Configuraci�n de la simulaci�n del PreparedStatement
	        when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);

	        // Configuraci�n de los datos de prueba
	        when(statementMock.executeQuery()).thenReturn(resultSetMock);
	        when(resultSetMock.next()).thenReturn(false); // Simula que no se encontraron resultados

	        // Creaci�n del objeto ClienteModelo con el mock de la conexi�n
	        ClienteModelo clienteModelo = new ClienteModelo();
	        clienteModelo.setConexion(connectionMock);

	        // Ejecuci�n del m�todo a probar
	        boolean resultado = clienteModelo.checkNumeroDisponible("123456789");

	        // Verificaci�n de los resultados esperados
	        assertTrue(resultado); // Se espera que el n�mero est� disponible
	    }
	 
	 @Test
	    void testCheckInt() {
	        // Creaci�n del objeto ClienteModelo
	        ClienteModelo clienteModelo = new ClienteModelo();

	        // Ejecuci�n del m�todo a probar
	        boolean resultado1 = clienteModelo.checkInt("123456"); // N�mero v�lido
	        boolean resultado2 = clienteModelo.checkInt("abc123"); // N�mero inv�lido

	        // Verificaci�n de los resultados esperados
	        assertTrue(resultado1); // Se espera que sea un n�mero v�lido
	        assertFalse(resultado2); // Se espera que no sea un n�mero v�lido
	    }

}