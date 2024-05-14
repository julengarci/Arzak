package controladorMenu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intermediaIngredientePlatos.IngredientesPlatosModelo;
import intermediaPlatosMenu.PlatosMenuModelo;
import modelo.Tipo;
import modeloMenu.Menu;
import modeloMenu.MenuModelo;
import modeloPlato.Plato;
import modeloPlato.PlatoModelo;

/**
 * Servlet implementation class UpdateMenu
 */
@WebServlet("/UpdateMenu")
public class UpdateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenu() {
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
		
		//guardar los valores del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		Double precio = Double.parseDouble(request.getParameter("precio"));
		
		String fechaInicioString = request.getParameter("fechaModificar");
		String fechaFinString = request.getParameter("fechaModificar2");

		
		Date fechaInicio = null;
		Date fechaFin = null;
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
		    fechaInicio = formatoFecha.parse(fechaInicioString);
		    fechaFin = formatoFecha.parse(fechaFinString);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
				
		//conseguir los valores del checkbox
		String[] platos = request.getParameterValues("platos[]");
		
		//añadir los valores al ojeto plato
		Menu menu = new Menu();
		
		menu.setId(id);
		menu.setPrecio(precio);
		menu.setFechaInicio(fechaInicio);
		menu.setFechaFin(fechaFin);
		
		//insertar en BBDD
		MenuModelo mm = new MenuModelo();
				
		mm.update(menu);
		
		//eliminar todas las lineas de codigo que hay en la tabla intermedia
		PlatosMenuModelo ppm = new PlatosMenuModelo();
		ppm.deleteMenuPlatos(id);
		
		//insertar los datos a la tabla intermedia
		for (String string : platos) {
			ppm.insertPlatosMenu(Integer.parseInt(string),id);
		}
				
		//redirigir al panel
		response.sendRedirect("PanelMenu");
	}

}
