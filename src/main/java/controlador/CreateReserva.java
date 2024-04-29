package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alergeno;
import modelo.Reserva;
import modelo.ReservaModelo;

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

		//recoger los datos del formulario
		String hora = request.getParameter("hora");
		
		String fechaString = request.getParameter("fecha");
		Date fecha = null;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
		    fecha = formatoFecha.parse(fechaString);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		int numPersonas = Integer.parseInt(request.getParameter("numPersonas"));
		
		String alergenoString = request.getParameter("alergeno");
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		
		String observaciones = request.getParameter("observaciones");
		
		//insertar los valores en el objeto ingrediente
		Reserva reserva = new Reserva();
		
		reserva.setHora(hora);
		reserva.setFecha(fecha);
		reserva.setNumPersonas(numPersonas);
		reserva.setAlergeno(alergeno);
		reserva.setObservaciones(observaciones);
		
		//insertar en bbdd
		ReservaModelo rm = new ReservaModelo();
		rm.insert(reserva);
		
		//redirigir al panel
		response.sendRedirect("PanelReserva");
	}

}
