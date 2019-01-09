package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1Main {
	
	private static Scanner entrada;
	private static Cuenta cuenta;

	public static void inicializar() {
		entrada = new Scanner(System.in);
		cuenta = null;
	}

	public static void main(String[] args) {
		inicializar();
		int opcion=0;
		do {
			System.out.println("Introduce la operación a realizar");
			System.out.println("1. Inicializar cuenta");
			System.out.println("2. Añadir saldo");
			System.out.println("3. Retirar saldo");
			System.out.println("0. Salir");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch(opcion) {
			case 1:
				inicializarCuenta();
				break;
			case 2:
				anadirSaldo();
				break;
			case 3:
				retirarSaldo();
				break;
			case 0:
				break;
			default:
				System.out.println("No has seleccionado ninguna opción");
			}
		} while (opcion != 0);
	}

	private static void inicializarCuenta() {
		System.out.println("Introduce el nombre del titular y pulsa intro");
		String titular = entrada.nextLine();
		System.out.println("Introduce la cantidad de saldo");
		double saldo = entrada.nextDouble();
		cuenta = new Cuenta(titular,saldo);
		System.out.println("El resultado de la operacion es: "+cuenta.toString());
	}
	
	private static void anadirSaldo() {
		if(cuenta != null) {
			System.out.println("Introduce la cantidad de saldo");
			double saldo = entrada.nextDouble();
			cuenta.ingresar(saldo);
			System.out.println("El resultado de la operacion es: "+cuenta.toString());
		} else {
			System.out.println("Debes inicializar la cuenta antes de esta operación");
		}
	}
	
	private static void retirarSaldo() {
		if(cuenta != null) {
			System.out.println("Introduce la cantidad de saldo");
			double saldo = entrada.nextDouble();
			cuenta.retirar(saldo);
			System.out.println("El resultado de la operacion es: "+cuenta.toString());
		} else {
			System.out.println("Debes inicializar la cuenta antes de esta operación");
		}	
	}
}
