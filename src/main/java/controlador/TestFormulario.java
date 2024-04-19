package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.ClienteModelo;
import modelo.Reserva;

/**
 * Servlet implementation class TestFormulario
 */
@WebServlet("/TestFormulario")
public class TestFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("testeoFormularioCliente.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		// Obtener parámetros del formulario y actualizar la base de datos
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        //introducir los datos en el objeto
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);        
        
        ClienteModelo cm = new ClienteModelo();
        cm.insert(cliente);

        //llama a la base de datos y añade los clientes a la ArrayList
        
	}

}
