package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.ClienteModelo;
import modelo.Plato;
import modelo.PlatoModelo;
import modelo.Tipo;

/**
 * Servlet implementation class UpdatePlato
 */
@WebServlet("/UpdatePlato")
public class UpdatePlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlato() {
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
		
		Plato plato = new Plato();
		
		// Obtener parámetros del formulario y actualizar la base de datos
		int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String tipoStr = request.getParameter("tipo");
        
        Tipo tipo = Tipo.valueOf(tipoStr);
        
        //introducir los datos en el objeto
        plato.setId(id);
        plato.setNombre(nombre);
        plato.setTipo(tipo);
        
        PlatoModelo pm = new PlatoModelo();
        
        pm.update(plato);

        response.sendRedirect("PanelPlato");
	}

}
