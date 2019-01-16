package es.indra.ejercicio7;

public class Raices {
	private double a;
	private double b;
	private double c;
	
	public Raices(double a, double b, double c) {
		super();
		this.a = a; 
		this.b = b;
		this.c = c;
	}
	
	public void obtenerRaices() {
		double x1=(-b+Math.sqrt(getDiscriminante()/(2*a)));
		double x2=(-b-Math.sqrt(getDiscriminante()/(2*a)));
		System.out.println("Solucion x1: "+x1);
		System.out.println("Solución x2: "+x2);
	}
	
	public void obtenerRaiz() {
		double x1 = (-b)/(2*a);
		System.out.println(x1);
	}
	
	public double getDiscriminante() {
		return Math.pow(b, 2)-(4*a*c);
	}
	
	public boolean tieneRaices() {
		if(getDiscriminante()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean tieneRaiz() {
		if(getDiscriminante() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void calcular() {
		if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		} else {
			System.out.println("La raiz no tiene solucion");
		}
	}
}
