package controladorMenu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;
import modeloMenu.Menu;
import modeloMenu.MenuModelo;
import modeloPlato.Plato;
import modeloPlato.PlatoModelo;

/**
 * Servlet implementation class PanelMenu
 */
@WebServlet("/PanelMenu")
public class PanelMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llama a la base de datos y a�ade los clientes a la ArrayList
		MenuModelo mm = new MenuModelo();
		ArrayList<Menu> menus = mm.getTodos();
		
		//creamos una lista de Ingedientes para poder escoger
		PlatoModelo pm = new PlatoModelo();
		ArrayList<Plato> platos = pm.getTodos();
						
		//genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("menus", menus);
		request.setAttribute("platos", platos);
						
		//ejecuta la pagina
		request.getRequestDispatcher("PanelMenus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
