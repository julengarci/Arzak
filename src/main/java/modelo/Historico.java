package modelo;

public class Historico {

	private String mes;
	private String a�o;
	private String nombre;
	private String telefono;
	private int veces;
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getVeces() {
		return veces;
	}
	public void setVeces(int veces) {
		this.veces = veces;
	}
	@Override
	public String toString() {
		return "Historico [mes=" + mes + ", a�o=" + a�o + ", nombre=" + nombre + ", telefono=" + telefono + ", veces="
				+ veces + "]";
	}
	
	
}
