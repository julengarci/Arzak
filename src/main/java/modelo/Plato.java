package modelo;

import java.util.ArrayList;

public class Plato {
	
	private int id;
    private String nombre;
    private Tipo tipo;
    private ArrayList<Ingrediente> ingredientes;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", ingredientes=" + ingredientes + "]";
	}
	
}
