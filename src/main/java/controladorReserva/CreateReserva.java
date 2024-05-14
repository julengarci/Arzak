package controladorReserva;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modeloCliente.Cliente;
import modeloReserva.Reserva;
import modeloReserva.ReservaModelo;

/**
 * Servlet implementation class CreateReserva
 */
@WebServlet("/CreateReserva")
public class CreateReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReserva() {
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
		String telefono = request.getParameter("telefono");
		
		//insertar los valores en el objeto ingrediente
		Reserva reserva = new Reserva();
		
		reserva.setHora(hora);
		reserva.setFecha(fecha);
		reserva.setNumPersonas(numPersonas);
		reserva.setObservaciones(observaciones);
		
		Cliente cliente = new Cliente();
		cliente.setTelefono(telefono);
		
		reserva.setCliente(cliente);
		
		// Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtener la fecha del formulario (deberías obtenerla desde tu formulario JSP)
        LocalDate fechaFormularioParsed = LocalDate.parse(fechaString);

        // Verificar si la fecha del formulario es posterior a la fecha actual
        boolean fechaIsAfter;
        if (fechaFormularioParsed.isAfter(fechaActual)) {
            fechaIsAfter = true;
            //insertar en bbdd
    		ReservaModelo rm = new ReservaModelo();
    		rm.insert(reserva, telefono);
        } else {
            fechaIsAfter = false;
        }
		
        request.setAttribute("fechaIsAfter", fechaIsAfter);
		
		//redirigir al panel
		request.getRequestDispatcher("PanelReserva").forward(request, response);
	}

}
