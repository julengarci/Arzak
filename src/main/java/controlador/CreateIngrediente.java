package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modelo.Ingrediente;
import modelo.IngredienteModelo;

/**
 * Servlet implementation class CreateIngrediente
 */
@WebServlet("/CreateIngrediente")
public class CreateIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateIngrediente() {
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
		String nombre = request.getParameter("nombre");
		String alergenoString = request.getParameter("alergeno");
		
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setNombre(nombre);
		ingrediente.setAlergeno(alergeno);
		
		IngredienteModelo im = new IngredienteModelo();
		im.insert(ingrediente);
		
		response.sendRedirect("PanelIngrediente");
	}

}
