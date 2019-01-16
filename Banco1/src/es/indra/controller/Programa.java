package es.indra.controller;

import java.util.Scanner;
import es.indra.model.Banco;

public class Programa {
	private static Scanner ENTRADA;
	//private static Banco b = null;

	public static void main(String[] args) {
		System.out.println("Programa Banco");
		int opcion = 0;
		do {
			System.out.println("1. Introducir un cliente");
			System.out.println("2. Crear una cuenta");
			System.out.println("3. Ingresar dinero");
			System.out.println("4. Sacar dinero");
			System.out.println("5. Revisión mensual de la cuenta");
			System.out.println("6. Estado de la cuenta");
			System.out.println("0. Salir");
			opcion = ENTRADA.nextInt();
			ENTRADA.nextLine();
			switch(opcion) {
			case 1:
				anadirCliente();
				break;
			case 2:
				crearCuenta();
				break;
			case 3:
				ingresarDinero();
				break;
			case 4:
				sacarDinero();
				break;
			case 5:
				efectuarRevisionMensual();
				break;
			case 6:
				estadoCuenta();
				break;
			case 0:
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		} while (opcion != 0);
	}
	
	public static void anadirCliente() {
		System.out.println("Opcion 1");
	}
	
	public static void crearCuenta() {
		
	}
	
	public static void ingresarDinero() {
		
	}
	
	public static void sacarDinero() {
		
	}
	
	
	public static void efectuarRevisionMensual() {
		
	}
	
	public static void estadoCuenta() {
		
	}

}
