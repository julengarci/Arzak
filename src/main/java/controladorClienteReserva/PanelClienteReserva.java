package controladorClienteReserva;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modelo.ClienteModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class PanelClienteReserva
 */
@WebServlet("/PanelClienteReserva")
public class PanelClienteReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelClienteReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llama a la base de datos y añade las reservas a la ArrayList
		ClienteModelo cm = new ClienteModelo();
		ReservaModelo rm = new ReservaModelo();
		ArrayList<Reserva> reservas = rm.getTodos();
		
		//creamos una lista de Alergeno (usando el enum)
		Alergeno[] alergenos = Alergeno.values();
		
		//genera un atributo con la ArrayList para que se pueda usar en la pagina
		request.setAttribute("reservas", reservas);
		request.setAttribute("alergenos", alergenos);
		
		//ejecuta la pagina
		request.getRequestDispatcher("reservaCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
