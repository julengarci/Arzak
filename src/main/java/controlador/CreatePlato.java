package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Plato;
import modelo.PlatoModelo;
import modelo.Tipo;

/**
 * Servlet implementation class CreatePlato
 */
@WebServlet("/CreatePlato")
public class CreatePlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePlato() {
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
		
		//guardar los valores del formulario
		String nombre = request.getParameter("nombre");
		String tipoStr = request.getParameter("tipo");
		
		//transformar string en tipo
		Tipo tipo = Tipo.valueOf(tipoStr);
		
		//añadir los valores al ojeto plato
		Plato plato = new Plato();
		
		plato.setNombre(nombre);
		plato.setTipo(tipo);
		
		//insertar en BBDD
		PlatoModelo pm = new PlatoModelo();
		
		pm.insert(plato);
		
		//redirigir al panel
		response.sendRedirect("PanelPlato");
	}

}
