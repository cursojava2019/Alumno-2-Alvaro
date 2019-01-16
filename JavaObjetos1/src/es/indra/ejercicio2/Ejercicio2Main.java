package es.indra.ejercicio2;

import java.util.Scanner;

public class Ejercicio2Main {
	
	private static Scanner entrada;

	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre"); 
		String nombre = entrada.next();
		System.out.println("Introduce la edad");
		int edad = entrada.nextInt();
		System.out.println("Introduce el sexo (H o M)");
		String sexo = entrada.next();
		System.out.println("Introduce el peso");
		double peso = entrada.nextDouble();
		System.out.println("Introduce la altura");
		double altura = entrada.nextDouble();
		
	     Persona persona1 = new Persona(nombre,edad,sexo,peso,altura);
	     
	     System.out.println("Persona1");
	     calculoPeso(persona1);
	     esMayorDeEdad(persona1);
	     System.out.println(persona1.toString());
	     }
	 
	public static void calculoPeso(Persona p) {
		int IMC = p.calcularIMC();
		switch (IMC) {
		case Persona.PESO_NORMAL:
			System.out.println("Tienes un peso normal");
			break;
	    case Persona.PESO_BAJO:
	        System.out.println("Tienes un peso por debajo de lo normal");
	        break;
	    case Persona.SOBREPESO:
	        System.out.println("Tienes un peso por encima de lo normal");
	        break;
	        }
	    }
	 
	public static void esMayorDeEdad(Persona p) {
		if (p.esMayorDeEdad()) {
			System.out.println("La persona es mayor de edad");
			} else {
				System.out.println("La persona no es mayor de edad");
	        }
		}

}
