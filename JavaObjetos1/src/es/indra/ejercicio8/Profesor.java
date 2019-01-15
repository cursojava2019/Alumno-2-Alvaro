package es.indra.ejercicio8;

public class Profesor extends Persona {
	private String materia;
	private boolean falta;
	
	public Profesor(String nombre, int edad, String sexo, String materia) {
		super(nombre, edad, sexo);

	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public boolean isFalta() {
		return falta;
	}

	public void setFalta(boolean falta) {
		this.falta = falta;
	}
	
	public boolean falta() {
		boolean falta = false;
		int probabilidad = (int)Math.random()*100+1;
		
		if(probabilidad > 20) {
			falta = true;
		} else {
			falta = false;
		}
		return falta;
	}
	
	public String asignatura(String materia) {
		String asignatura = "null";
		if (materia.equalsIgnoreCase("Matematicas") || materia.equalsIgnoreCase("Filosofia")
				|| materia.equalsIgnoreCase(""
						+ "Fisica")) {
			asignatura = materia;
		} else {
			asignatura = "Matematicas";
		}
		return asignatura;
	}
	
}
