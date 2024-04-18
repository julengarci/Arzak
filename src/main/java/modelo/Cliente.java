package modelo;

public class Cliente {
	
	private int id;
	private String nombre;
	private String telefono;
	private String email;
	
	
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
	public String getTelefonoString() {
		return telefono;
	}
	public void setTelefonoString(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", telefonoString=" + telefono + ", email=" + email
				+ "]";
	}
}
