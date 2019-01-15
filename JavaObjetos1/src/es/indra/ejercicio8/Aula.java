package es.indra.ejercicio8;

import java.util.ArrayList;

public class Aula {
	private int id;
	private int maxAlumnos;
	private String destinada;
	public Profesor profesor;
	public ArrayList<Alumno> alumnos;
	
	public Aula(int id, int maxAlumnos, String destinada, Profesor profesor, ArrayList<Alumno> alumnos) {
		super();
		this.id = id;
		this.maxAlumnos = maxAlumnos;
		this.destinada = destinada;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxAlumnos() {
		return maxAlumnos;
	}

	public void setMaxAlumnos(int maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}

	public String getDestinada() {
		return destinada;
	}

	public void setDestinada(String destinada) {
		this.destinada = destinada;
	}
	
	public boolean darClase() {
		boolean darClase = true;
		if (this.profesor.falta() == false && this.profesor.getMateria().equalsIgnoreCase(this.destinada)
				&& this.alumnos.size() >= (this.maxAlumnos / 2)) {
			darClase = true;
		} else {
			darClase = false;
		}
		return darClase;
	}
	
	public void darNotas() {
		
	}
	
}
