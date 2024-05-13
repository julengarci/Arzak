package controladorPlato;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloIngrediente.IngredienteModelo;
import modeloPlato.PlatoModelo;

/**
 * Servlet implementation class DeletePlato
 */
@WebServlet("/DeletePlato")
public class DeletePlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlatoModelo pm = new PlatoModelo();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		pm.delete(id);
		
		//bolean para validacion
		boolean alertDelete = true;
		
		request.setAttribute("alertDelete", alertDelete);
		
		//redirigir al panel
		request.getRequestDispatcher("PanelPlato").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
