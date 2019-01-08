/**
 * 
 */
package es.indra.ejercicio4;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner numero = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int leido1 = numero.nextInt();
		String num = Integer.toString(leido1);
		if(num.contains("-")) {
			System.out.println("El numero "+leido1+" no es un número entero positivo");
		} else if(num.length() == 1) {
			System.out.println("El numero "+leido1+" tiene 1 dígito");
		} else if(num.length() == 2) {
			System.out.println("El numero "+leido1+" tiene 2 dígitos");
		} else if(num.length() >= 3) {
			System.out.println("El numero "+leido1+" tiene mas de 2 dígitos ("+num.length()+")");
		} else {
			System.out.println("No has introducido un numero");
		}
		
	}

}
