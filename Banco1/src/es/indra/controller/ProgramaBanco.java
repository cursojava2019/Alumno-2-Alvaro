package es.indra.controller;

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

import es.indra.model.Banco;
import es.indra.model.Cliente;
import es.indra.model.Cuenta;


public class ProgramaBanco {
	
	private static Scanner ENTRADA;
	public static final String FICHERO_BANCO = "banco.txt";
	public static final String FICHERO_CUENTAS = "cuentas.dat";
	private static Banco banco = null;


	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		
		File file = new File(FICHERO_CUENTAS);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			banco = (Banco) objectInput.readObject();
    		objectInput.close();
     	} catch (FileNotFoundException e) {
			banco = new Banco();
			System.out.println("Iniciando banco desde cero");
		}
	}

	public static void fin() throws IOException {
		File file = new File(FICHERO_CUENTAS);
		file.delete();
		file.createNewFile();
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(banco);
			objectOut.flush();
			objectOut.close();
		} catch (IOException e) {
			System.out.println("Error al guardar en disco, todo se ha perdido");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Archivo banco no encontrado, iniciando desde cero");
			banco = new Banco();
		}
		ENTRADA = new Scanner(System.in);
		banco = new Banco(); //IMPORTANTE 
		System.out.println("BIENVENIDO AL BANCO");
		int opcion = 0;
		try {
			do {
				System.out.println("Introduzca la operacion que desea realizar");
				System.out.println("1.- Introducir Cliente");
				System.out.println("2.- Crear Cuenta");
				System.out.println("3.- Realizar ingreso");
				System.out.println("4.- Sacar dinero");
				System.out.println("5.- Forzar revision mensual");
				System.out.println("6.- Estado de la cuenta");
				System.out.println("0.- Salir");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();
				switch (opcion) {
				case 1:
					aniadirCliente();
					fin();
					break;
				case 2:
					creaCuenta();
					fin();
					break;
				case 3:
					realizarIngreso();
					fin();
					break;
				case 4:
					retirarDinero();
					fin();
					break;
				case 5:
					forzarRevisionMensual();
					fin();
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
		System.out.println("Introduce Telefono: ");
		String telefono = ENTRADA.nextLine();
		System.out.println("Introduce Direccion: ");
		String direccion = ENTRADA.nextLine();

		Cliente cliente = new Cliente(dni, nombre, apellidos, telefono, direccion);
		banco.introducirCliente(cliente);
	}

	public static void creaCuenta() {
		System.out.println("Introduce los datos de la cuenta: ");

		System.out.println("Introduce numero de cuenta: ");
		String id = ENTRADA.nextLine();
		System.out.println("Introduce saldo de la cuenta: ");
		Float saldo = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		System.out.println("Introduce dni del cliente: ");
		String dni = ENTRADA.nextLine();
		Cliente cliente = banco.obtenerCliente(dni);
		System.out.println("Introduce tipo de cuenta: ");
		String tipocuenta = ENTRADA.nextLine();

		Cuenta cuenta = new Cuenta(id, cliente, tipocuenta, saldo);
		banco.crearCuenta(cuenta);
	}

	public static void realizarIngreso() {
		System.out.println("Introduce el numero de cuenta: ");
		String id = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cliente cliente = banco.obtenerCliente(dni);

		if (cliente == null) {
			System.out.println("No existe ese cliente");
			return;
		}

		System.out.println("Introduce la cantidad a ingresar: ");
		Float cantidad = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		Cuenta operacion = banco.realizarIngreso(dni, id, cantidad);

		if (operacion != null) {
			File file = new File(FICHERO_BANCO);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileWriter salida;
			try {
				salida = new FileWriter(file, true);
				salida.write(operacion.toString());
				salida.flush();
				salida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Ingreso realizado correctamente");
		} else {
			System.out.println("Error no se ha podido realizar el ingreso");
		}
	}

	public static void retirarDinero() {
		System.out.println("Introduzca el numero de cuenta: ");
		String id = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		System.out.println("Introduce DNI del cliente: ");
		String dni = ENTRADA.nextLine();

		Cliente cliente = banco.obtenerCliente(dni);

		if (cliente == null) {
			System.out.println("No existe ese cliente");
			return;
		}

		System.out.println("Introduce la cantidad a retirar: ");
		Float cantidad = ENTRADA.nextFloat();
		ENTRADA.nextLine();
		Cuenta operacion = banco.sacarDinero(dni, id, cantidad);

		if (operacion != null) {
			File file = new File(FICHERO_BANCO);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileWriter salida;
			try {
				salida = new FileWriter(file, true);
				salida.write(operacion.toString());
				salida.flush();
				salida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Dinero sacado correctamente");
		} else {
			System.out.println("Error no se ha realizado la operacion");
		}
	}

	public static void forzarRevisionMensual() {
		System.out.println("Introduce el numero de cuenta:");
		String id = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		}

		System.out.println("Introduce DNI: ");
		String dni = ENTRADA.nextLine();

		Cliente cliente = banco.obtenerCliente(dni);

		if (cliente == null) {
			System.out.println("No existe ese cliente");
			return;
		}

		Cuenta operacion = banco.revisionMensual(dni, id);

		if (operacion != null) {
			File file = new File(FICHERO_BANCO);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileWriter salida;
			try {
				salida = new FileWriter(file, true);
				salida.write(operacion.toString());
				salida.flush();
				salida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Revision realizada correctamente");
		} else {
			System.out.println("Error revision no realizada");
		}
	}

	public static void verEstadoCuenta() {
		System.out.println("Introduce numero de cuenta: ");
		String id = ENTRADA.nextLine();

		Cuenta cuenta = banco.obtenerCuenta(id);
		if (cuenta == null) {
			System.out.println("No existe esa cuenta");
			return;
		} else {
			System.out.println(cuenta.toString());
		}
	}
}