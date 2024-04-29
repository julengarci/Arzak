package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modelo.Ingrediente;
import modelo.IngredienteModelo;
import modelo.Plato;
import modelo.PlatoModelo;
import modelo.Tipo;

/**
 * Servlet implementation class PanelPlatos
 */
@WebServlet("/PanelPlato")
public class PanelPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelPlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//llama a la base de datos y añade los ingredientes a la ArrayList
		PlatoModelo pm = new PlatoModelo();
		ArrayList<Plato> platos = pm.getTodos();
		
		//creamos una lista de Alergeno (usando el enum)
		Tipo[] tipos = Tipo.values();		
		
		//genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("platos", platos);
		request.setAttribute("tipos", tipos);
								
		//ejecuta la pagina
		request.getRequestDispatcher("PanelPlatos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
