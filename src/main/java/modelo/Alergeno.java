package modelo;

public enum Alergeno {

	 ninguno("NINGUNO"),
	 gluten("GLUTEN"),
	 crustaceos("CRUSTACEOS"),
	 moluscos("MOLUSCOS"),
	 pescado("PESCADO"),
	 huevos("HUEVOS"),
	 altramuces("ALTRAMUCES"),
	 mostaza("MOSTAZA"),
	 cacahuetes("CACAHUETES"),
	 frutossecos("FRUTOS SECOS"),
	 soja("SOJA"),
	 sesamo("SESAMO"),
	 apio("APIO"),
	 leche("LECHE"),
	 anhidridosulfuroso("ANHIDRIDO SULFUROSO");
	
	 private String nombre;

	    Alergeno(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getNombre() {
	        return this.nombre;
	    }    
}

