/**
 * 
 */
package es.indra.ejercicio3;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner dia = new Scanner(System.in);
		System.out.println("Introduce el d�a de la semana");
		String leido = dia.next();
		
		switch(leido) {
		case "lunes":
		case "martes":
		case "miercoles":
		case "jueves":
		case "viernes":
			System.out.println("Hoy es d�a laborable");
			break;
		case "sabado":
		case "domingo":
			System.out.println("Hoy es festivo");
			break;
		}
	}

}
