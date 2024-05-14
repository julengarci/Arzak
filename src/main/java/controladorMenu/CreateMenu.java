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
 * Servlet implementation class CreateMenu
 */
@WebServlet("/CreateMenu")
public class CreateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMenu() {
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
		
		//guardar los valores del formulario
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		String fechaInicioString = request.getParameter("fechaInicio");
		String fechaFinString = request.getParameter("fechaFin");
		
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
				
		//añadir los valores al ojeto menu
		Menu menu = new Menu();
				
		menu.setPrecio(precio);
		menu.setFechaInicio(fechaInicio);
		menu.setFechaFin(fechaFin);
				
		//insertar en BBDD
		MenuModelo mm = new MenuModelo();
				
		mm.insert(menu);
				
		//insertar los datos a la tabla intermedia
		PlatosMenuModelo pmm = new PlatosMenuModelo();
		int idUltimoMenu = mm.getUltimoMenu();
		for (String string : platos) {
			pmm.insertPlatosMenu(Integer.parseInt(string), idUltimoMenu);
		}
				
		//redirigir al panel
		response.sendRedirect("PanelMenu");
	}

}
