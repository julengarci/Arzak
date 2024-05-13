package controladorCliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;

/**
 * Servlet implementation class CreateCliente
 */
@WebServlet("/CreateCliente")
public class CreateCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recoger los datos del formulario
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		//insertar los valores en el objeto cliente
		Cliente cliente = new Cliente();
		
		cliente.setNombre(nombre);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		
		//insertar en BBDD
		ClienteModelo cm = new ClienteModelo();
		
		//atributo para mostrar alertas
		boolean esNumero;
		if (cm.checkInt(telefono) == true) {
			esNumero = true;
		}
		else {
			esNumero = false;
		}
		
		if (esNumero == true) {
			boolean numeroDisponible;
			if (cm.checkNumeroDisponible(telefono) == true) {
				cm.insert(cliente);
				numeroDisponible = true;
			}
			else {
				numeroDisponible = false;
			}
			
			request.setAttribute("numeroDisponible", numeroDisponible);
		}
		
		request.setAttribute("esNumero", esNumero);
		
		//redirigir al panel
		request.getRequestDispatcher("PanelCliente").forward(request, response);
	}

}
