package es.indra.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import es.indra.controller.Banco;
import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;


public class Programa {
	
	private static Scanner ENTRADA;
	private static Banco banco = null;

	public static void main(String[] args) {
		ENTRADA = new Scanner(System.in);
		banco = new Banco();
		System.out.println("BIENVENIDO AL BANCO");
		int opcion = 0;
		try {
			do {
				System.out.println("Introduce la operacion que desea realizar");
				System.out.println("1. Introducir Cliente");
				System.out.println("2. Crear Cuenta");
				System.out.println("3. Realizar ingreso");
				System.out.println("4. Sacar dinero");
				System.out.println("5. Forzar revision mensual");
				System.out.println("6. Estado de la cuenta");
				System.out.println("0. Salir");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();
				switch (opcion) {
				case 1:
					aniadirCliente();
					break;
				case 2:
					creaCuenta();
					break;
				case 3:
					realizarIngreso();
					break;
				case 4:
					retirarDinero();
					break;
				case 5:
					forzarRevisionMensual();
					break;
				case 6:
					verEstadoCuenta();
					break;
				case 0:
					System.out.println("Fin del Programa");
					break;
				default:
					break;
				}
			} while (opcion != 0);
			
		} catch (Exception e) {
			System.out.println("Error al guardar en fichero");
			e.printStackTrace();
		}
	}

	public static void aniadirCliente() {
		System.out.println("Introduce los datos del cliente: ");

		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();
		System.out.println("Introduce Nombre: ");
		String nombre = ENTRADA.nextLine();
		System.out.println("Introduce Apellidos: ");
		String apellidos = ENTRADA.nextLine();
		System.out.println("Introduce Direccion: ");
		String direccion = ENTRADA.nextLine();
		System.out.println("Introduce Telefono: ");
		String telefono = ENTRADA.nextLine();

		Cliente cliente = new Cliente(dni, nombre, apellidos, direccion, telefono);
		banco.introducirCliente(cliente);
	}

	public static void creaCuenta() {
		Float comision = null;
		System.out.println("Introduce los datos de la cuenta: ");

		System.out.println("Introduce numero de cuenta: ");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce saldo de la cuenta: ");
		Float saldo = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		System.out.println("Introduce dni del cliente: ");
		String dniCliente = ENTRADA.nextLine();
		System.out.println("Introduce tipo de cuenta: ");
		String tipocuenta = ENTRADA.nextLine();
		if(tipocuenta.equalsIgnoreCase("CC")) {
			comision = (float) 0.1;
		} else if (tipocuenta.equalsIgnoreCase("CV")) {
			comision = (float) 0.2;
		} else if (tipocuenta.equalsIgnoreCase("FI")) {
			comision = (float) 0.34;
		}

		Cuenta cuenta = new Cuenta(id,comision,tipocuenta,saldo,dniCliente);
		banco.crearCuenta(cuenta);
	}

	public static void realizarIngreso() {
		System.out.println("Introduce el numero de cuenta: ");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(dni,id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		System.out.println("Introduce la cantidad a ingresar: ");
		Float cantidad = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		Cuenta operacion = banco.realizarIngreso(cuenta,cantidad);

		if (operacion != null) {
			System.out.println("Ingreso realizado correctamente");
		} else {
			System.out.println("Error no se ha podido realizar el ingreso");
		}
	}

	public static void retirarDinero() {
		System.out.println("Introduce el numero de cuenta: ");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(dni,id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		System.out.println("¿Cuanto dinero quieres sacar?");
		Float cantidad = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		Cuenta operacion = banco.sacarDinero(cuenta,cantidad);

		if (operacion != null) {
			System.out.println("Dinero retirado correctamente");
		} else {
			System.out.println("Error no se ha podido realizar la operacion");
		}
	}

	public static void forzarRevisionMensual() {
		System.out.println("Introduce el numero de cuenta:");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(dni,id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		Cuenta operacion = banco.forzarRevisionMensual(cuenta);

		if (operacion != null) {
			System.out.println("Revision realizada correctamente");
		} else {
			System.out.println("Error revision no realizada");
		}
	}

	public static void verEstadoCuenta() {
		System.out.println("Introduce numero de cuenta: ");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(dni,id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		} else {
			System.out.println(cuenta.toString());
		}
	}
}
