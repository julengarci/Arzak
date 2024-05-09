package controladorReserva;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modeloReserva.Reserva;
import modeloReserva.ReservaModelo;
import modelo.Cliente;
import modelo.ClienteModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class PanelReservas
 */
@WebServlet("/PanelReserva")
public class PanelReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//llama a la base de datos y añade las reservas a la ArrayList
		ReservaModelo rm = new ReservaModelo();
		ClienteModelo cm = new ClienteModelo();
		
		ArrayList<Reserva> reservas = rm.getTodos();
		ArrayList<Cliente> clientes = cm.getTodos();
	
		//genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("reservas", reservas);
		request.setAttribute("clientes", clientes);
		
		//ejecuta la pagina
		request.getRequestDispatcher("PanelReservas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
