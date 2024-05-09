package modeloIngrediente;

import modelo.Alergeno;

public class Ingrediente {

	private int id;
    private String nombre;
    private Alergeno alergeno;
    
    
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
	public Alergeno getAlergeno() {
		return alergeno;
	}
	public void setAlergeno(Alergeno alergeno) {
		this.alergeno = alergeno;
	}
	
	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombre=" + nombre + ", alergeno=" + alergeno + "]";
	}
      
}
