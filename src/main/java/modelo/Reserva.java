package modelo;

import java.sql.Time;
import java.util.Date;

public class Reserva {
	
	private int id;
	private Date fecha;
	private String hora;
	private int numPersonas;
	private String alergenos;
	private String observaciones;
	private Cliente cliente;
	private Menu menu;
	
	
	public Reserva() {
		
	}
	
	
	public Reserva(int id, Date fecha, String hora, int numPersonas, String alergenos, String observaciones,
			Cliente cliente, Menu menu) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.numPersonas = numPersonas;
		this.alergenos = alergenos;
		this.observaciones = observaciones;
		this.cliente = cliente;
		this.menu = menu;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public int getNumPersonas() {
		return numPersonas;
	}


	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}


	public String getAlergenos() {
		return alergenos;
	}


	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", numPersonas=" + numPersonas
				+ ", alergenos=" + alergenos + ", observaciones=" + observaciones + ", cliente=" + cliente + ", menu="
				+ menu + "]";
	}



	
	
}
