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
import modelo.Ingrediente;
import modelo.IngredienteModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class UpdateReserva
 */
@WebServlet("/UpdateReserva")
public class UpdateReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReserva() {
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
		
		Reserva reserva = new Reserva();
		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy"); 

		//Obtener parametros del formulario y actualizar la base de datos
		int id = Integer.parseInt(request.getParameter("id"));
		Date fecha = null;
		try {
			fecha = fechaFormat.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hora = request.getParameter("hora");
		int numPersonas = Integer.parseInt(request.getParameter("numPersonas"));
		String alergenoString = request.getParameter("alergeno");
		String observaciones = request.getParameter("observaciones");
		//Cliente cliente = request.getParameter
		//Menu menu = request.getParameter
		
		
		//introducir los datos en el objeto
		reserva.setId(id);
		reserva.setFecha(fecha);
		reserva.setHora(hora);
		reserva.setNumPersonas(numPersonas);
		Alergeno alergeno = Alergeno.valueOf(alergenoString);
		reserva.setObservaciones(observaciones);
		
		ReservaModelo rm = new ReservaModelo();
		
		rm.update(reserva);
		
		response.sendRedirect("PanelIngrediente");
	}

}
