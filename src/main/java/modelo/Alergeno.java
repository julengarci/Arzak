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
	 frutos_secos("FRUTOS SECOS"),
	 soja("SOJA"),
	 sesamo("SESAMO"),
	 apio("APIO"),
	 leche("LECHE"),
	 anhidrido_sulfuroso("ANHIDRIDO SULFUROSO");
	
	 private String nombre;

	    Alergeno(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getNombre() {
	        return this.nombre;
	    }    
}

