package es.indra.ejercicio3;

import java.util.Scanner;

public class Ejercicio3Main {
	
	private static Scanner entrada; 

	public static void main(String[] args) {
		entrada = new Scanner(System.in);
        System.out.println("Introduce el numero de contraseñas");
        int tamano=entrada.nextInt();
        System.out.println("Introduce la longitud de la contraseña");
        int longitud=entrada.nextInt();
  
        Password listaPassword[]=new Password[tamano];
        boolean fortalezaPassword[]=new boolean[tamano];
  
        for(int i=0;i<listaPassword.length;i++){
            listaPassword[i]=new Password(longitud);
            fortalezaPassword[i]=listaPassword[i].esFuerte();
            System.out.println(listaPassword[i].getContrasena()+" "+fortalezaPassword[i]);
        }
    }

}
