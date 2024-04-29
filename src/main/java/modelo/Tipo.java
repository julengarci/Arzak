package modelo;

public enum Tipo {

	primero("PRIMERO"),
	segundo("SEGUNDO"),
	postre("POSTRE");
	
	private String nombre;
	
	Tipo(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
