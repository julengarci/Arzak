package controladorClienteReserva;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladorCliente.CreateCliente;
import controladorReserva.CreateReserva;
import modelo.Alergeno;
import modeloCliente.Cliente;
import modeloCliente.ClienteModelo;
import modeloReserva.Reserva;
import modeloReserva.ReservaModelo;

/**
 * Servlet implementation class CreateClienteReserva
 */
@WebServlet("/CreateClienteReserva")
public class CreateClienteReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClienteReserva() {
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
		//Recoger los datos del formulario
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		//insertar los valores en el objeto cliente
		Cliente cliente = new Cliente();
		
		cliente.setNombre(nombre);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		
		//insertar en BBDD
		ClienteModelo cm = new ClienteModelo();
		cm.insert(cliente);
		
		//Recoger los datos del formulario
				String hora = request.getParameter("hora");
				
				String fechaString = request.getParameter("fecha");
				
				Date fecha = null;
				SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
				    fecha = formatoFecha.parse(fechaString);
				} catch (ParseException e) {
				    e.printStackTrace();
				}
				int numPersonas = Integer.parseInt(request.getParameter("numPersonas"));
				
				
				String observaciones = request.getParameter("observaciones");
				
				//insertar los valores en el objeto ingrediente
				Reserva reserva = new Reserva();
				
				reserva.setHora(hora);
				reserva.setFecha(fecha);
				reserva.setNumPersonas(numPersonas);
				reserva.setObservaciones(observaciones);
				
				
				//insertar en bbdd
				ReservaModelo rm = new ReservaModelo();
				rm.insert(reserva,cliente.getTelefono());
		
		//redirigir al panel
		response.sendRedirect("PanelClienteReserva");
	}

}
