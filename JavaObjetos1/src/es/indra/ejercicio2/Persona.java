package es.indra.ejercicio2;

public class Persona {
	private final static char SEXO='H';
	private final static int PESO_BAJO = -1;
	private final static int PESO_NORMAL = 0;
	private final static int SOBREPESO = 1;
	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	
	public Persona() {
        this("", 0, SEXO);
    }

	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public Persona(String nombre, int edad, String dni, char sexo, int peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSEXO(char sexo) {
		this.sexo = sexo;
	}

	public void setPeso(int peso) {
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
	
	public void esMayorDeEdad() {
		
	}
	
	public void comprobarSexo(char sexo) {
		
	}
	
	public void generaDNI() {
		
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + dni + ", SEXO=" + SEXO + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
}
