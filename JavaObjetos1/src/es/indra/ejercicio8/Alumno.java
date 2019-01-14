package es.indra.ejercicio8;

public class Alumno extends Persona{
	private int calificacion;
	private boolean falta;

	public Alumno(String nombre, int edad, String sexo, Integer calificacion) {
		super(nombre, edad, sexo);

	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Boolean getFalta() {
		return falta;
	}

	public void setFalta(Boolean falta) {
		this.falta = falta;
	}
	
	public boolean falta() {
		boolean falta = false;
		int probabilidad = (int)Math.random()*100+1;
		
		if(probabilidad > 50) {
			falta = true;
		} else {
			falta = false;
		}
		return falta;
	}
	
	public int calificacion(int calificacion) {
		int resultado = 0;
		if (resultado < 0) {
			resultado = 0;
		} else if (resultado > 10) {
			resultado = 10;
		} else {
			resultado = calificacion;
		}
		return resultado;
	}
}
