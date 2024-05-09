package controladorIngrediente;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;
import modeloPlato.Plato;
import modeloPlato.PlatoModelo;

/**
 * Servlet implementation class PanerIngrediente
 */
@WebServlet("/PanelIngrediente")
public class PanelIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanelIngrediente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// llama a la base de datos y añade los ingredientes a la ArrayList
		IngredienteModelo im = new IngredienteModelo();
		ArrayList<Ingrediente> ingredientes = im.getTodos();
		
		//creamos una lista de Alergeno (usando el enum)
		Alergeno[] alergenos = Alergeno.values();
		
		// genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("ingredientes", ingredientes);
		request.setAttribute("alergenos", alergenos);
		
		// ejecuta la pagina
		request.getRequestDispatcher("PanelIngredientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
