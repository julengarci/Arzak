package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Menu {

	private int id;
	private double precio;
	private Date fechaInicio;
	private Date fechaFin;
	private ArrayList<Plato> platos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public ArrayList<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", precio=" + precio + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", platos=" + platos + "]";
	}
}
