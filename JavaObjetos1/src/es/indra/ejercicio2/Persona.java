package es.indra.ejercicio2;

public class Persona {
	private final static String SEXO= "H";
	final static int PESO_BAJO = -1;
    final static int PESO_NORMAL = 0;
	final static int SOBREPESO = 1;
	private String nombre;
	private int edad;
	private String dni; 
	private String sexo;
	private double peso;
	private double altura;
	
	public Persona() {
        this("", 0, SEXO);
    }

	public Persona(String nombre, int edad, String sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public Persona(String nombre, int edad, String sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		comprobarSexo();
		generarDni();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int calcularIMC() {
		double pesoActual = peso/(altura*2);
		if (pesoActual < 20) {
			return PESO_BAJO;
		} else if (pesoActual >=20 && pesoActual <=25) {
			return PESO_NORMAL;
		} else {
			return SOBREPESO;
		}
	}
	
	public boolean esMayorDeEdad() {
		boolean mayorEdad = false;
		if (edad >= 18) {
			mayorEdad = true;
		}
		return mayorEdad;
	}
	
	public void comprobarSexo() {
		if (sexo != "H" && sexo != "M") {
			this.sexo = SEXO;
		}
	}
	
	private void generarDni() {
        final int divisor = 23;
 
        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
        int res = numDNI - (numDNI / divisor * divisor);
 
        char letraDNI = generaLetraDNI(res);
 
        dni = Integer.toString(numDNI) + letraDNI;
    }
 
    private char generaLetraDNI(int res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y','F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
        return letras[res];
    }

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + dni + ", SEXO=" + SEXO + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
}
