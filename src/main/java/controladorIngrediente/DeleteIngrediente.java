package controladorIngrediente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloIngrediente.IngredienteModelo;

/**
 * Servlet implementation class DeleteIngrediente
 */
@WebServlet("/DeleteIngrediente")
public class DeleteIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIngrediente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IngredienteModelo im = new IngredienteModelo();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		im.delete(id);
		
		//booleano para visualizar mensajes de validacion
		boolean alertaDelete = true;
		
		request.setAttribute("alertaDelete", alertaDelete);

		//redirigir al panel
		request.getRequestDispatcher("PanelIngrediente").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
