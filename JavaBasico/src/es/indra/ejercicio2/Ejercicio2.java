/**
 * 
 */
package es.indra.ejercicio2;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner numero1 = new Scanner(System.in);
		System.out.println("Introduce el primer número");
		int leido1 = numero1.nextInt();
		
		Scanner numero2 = new Scanner(System.in);
		System.out.println("Introduce el segundo número");
		int leido2 = numero2.nextInt();
		
		for(int i=leido1;i<=leido2;i++) {
			System.out.print(i+" ");
		}
	}

}
