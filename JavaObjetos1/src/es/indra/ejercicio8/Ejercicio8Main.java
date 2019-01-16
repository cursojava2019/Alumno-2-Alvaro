package es.indra.ejercicio8;

import java.util.ArrayList;

public class Ejercicio8Main {

	public static void main(String[] args) {
		Profesor p1 = new Profesor("Alvaro", 40, "Hombre", "Matematicas");
		
		Alumno a1 = new Alumno("Juan", 16, "Hombre", 4);
		Alumno a2 = new Alumno("Jose", 20, "Hombre", 7);
		Alumno a3 = new Alumno("Nerea", 18, "Mujer", 10);
		
		ArrayList<Alumno> array = new ArrayList<Alumno>();
		array.add(a1);
		array.add(a2);
		array.add(a3);

		Aula aula = new Aula(1, 3, "Fisica", p1, array);

		System.out.println(aula.darClase());
		aula.notasDeClase();

	}

}
