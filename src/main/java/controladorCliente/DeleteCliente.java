package controladorCliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloCliente.ClienteModelo;

/**
 * Servlet implementation class DeleteCliente
 */
@WebServlet("/DeleteCliente")
public class DeleteCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteModelo cm = new ClienteModelo();
		
		String telefono = request.getParameter("telefono");
		
		cm.delete(telefono);
		
		boolean alertDelete = true;
		
		request.setAttribute("alertDelete", alertDelete);
        
  		//redirigir al panel
  		request.getRequestDispatcher("PanelCliente").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
