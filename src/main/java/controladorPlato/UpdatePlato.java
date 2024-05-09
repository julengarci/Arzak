package controladorPlato;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.IngredientesPlatosModelo;
import modelo.Tipo;
import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloPlato.Plato;
import modeloPlato.PlatoModelo;

/**
 * Servlet implementation class UpdatePlato
 */
@WebServlet("/UpdatePlato")
public class UpdatePlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlato() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String tipoStr = request.getParameter("tipo");
		
		//transformar string en tipo
		Tipo tipo = Tipo.valueOf(tipoStr);
				
		//conseguir los valores del checkbox
		String[] ingredientes = request.getParameterValues("ingredientes[]");
				
		//añadir los valores al ojeto plato
		Plato plato = new Plato();
		
		plato.setId(id);
		plato.setNombre(nombre);
		plato.setTipo(tipo);
		
		//insertar en BBDD
		PlatoModelo pm = new PlatoModelo();
				
		pm.update(plato);
		
		//eliminar todas las lineas de codigo que hay en la tabla intermedia
		IngredientesPlatosModelo ipm = new IngredientesPlatosModelo();
		ipm.deletePlatosIngredientes(Integer.parseInt(request.getParameter("id")));
		
		//insertar los datos a la tabla intermedia
		for (String string : ingredientes) {
			ipm.insertIngredientesPlatos(Integer.parseInt(string), Integer.parseInt(request.getParameter("id")));
		}
				
		//redirigir al panel
		response.sendRedirect("PanelPlato");
	}

}
