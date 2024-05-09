package controladorIngrediente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;

/**
 * Servlet implementation class UpdateIngrediente
 */
@WebServlet("/UpdateIngrediente")
public class UpdateIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIngrediente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Ingrediente ingrediente = new Ingrediente();
		
		//Obtener parametros del formulario y actualizar la base de datos
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String alergenoString = request.getParameter("alergeno");
		String observaciones = request.getParameter("observaciones");
		
		//introducir los datos en el objeto
		ingrediente.setId(id);
		ingrediente.setNombre(nombre);
		
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		ingrediente.setAlergeno(alergeno);
		
		IngredienteModelo im = new IngredienteModelo();
		
		im.update(ingrediente);
		
		response.sendRedirect("PanelIngrediente");
		
	}

}
