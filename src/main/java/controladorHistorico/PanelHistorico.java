package controladorHistorico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloHistorico.Historico;
import modeloHistorico.HistoricoModelo;

/**
 * Servlet implementation class PanelHistorico
 */
@WebServlet("/PanelHistorico")
public class PanelHistorico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelHistorico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//llama a la base de datos y añade los clientes a la ArrayList
		HistoricoModelo hm = new HistoricoModelo();
		ArrayList<Historico> historicos = hm.getTodos();
		
		//genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("historicos", historicos);
						
		//ejecuta la pagina
		request.getRequestDispatcher("PanelHistoricos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
