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
import modeloIngrediente.Ingrediente;
import modeloIngrediente.IngredienteModelo;
import modeloMenu.Menu;
import modeloMenu.MenuModelo;
import modeloReserva.Reserva;
import modeloReserva.ReservaModelo;


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
		
		//Obtener parametros del formulario y actualizar la base de datos
		int id = Integer.parseInt(request.getParameter("id"));
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
		
		//String alergenoString = request.getParameter("alergeno");		
		String observaciones = request.getParameter("observaciones");

		
		String telefono = request.getParameter("telefono");

		//introducir los datos en el objeto
		reserva.setId(id);
		reserva.setHora(hora);
		reserva.setFecha(fecha);
		reserva.setNumPersonas(numPersonas);
		reserva.setObservaciones(observaciones);
		
		Cliente cliente = new Cliente();
		cliente.setTelefono(telefono);
		
		reserva.setCliente(cliente);
		
		//insertar el menu asociado a la fecha
		MenuModelo mm = new MenuModelo();
		Menu menu = mm.getMenuFecha(fechaString);
		
		reserva.setMenu(menu);

		// Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtener la fecha del formulario (deber�as obtenerla desde tu formulario JSP)
        LocalDate fechaFormularioParsed = LocalDate.parse(fechaString);

        // Verificar si la fecha del formulario es posterior a la fecha actual
        boolean fechaIsAfterUpdate;
        if (fechaFormularioParsed.isAfter(fechaActual)) {
        	fechaIsAfterUpdate = true;
            //insertar en bbdd
    		ReservaModelo rm = new ReservaModelo();
    		boolean peticion = rm.update(reserva);
    		request.setAttribute("peticion", peticion);
        } else {
        	fechaIsAfterUpdate = false;
        }
		
        request.setAttribute("fechaIsAfterUpdate", fechaIsAfterUpdate);
		
		//redirigir al panel
		request.getRequestDispatcher("PanelReserva").forward(request, response);
		
	}

}
