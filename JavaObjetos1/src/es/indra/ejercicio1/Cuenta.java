package es.indra.ejercicio1;

public class Cuenta {
	protected String titular;
	protected Double cantidad;
	
	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = Double.valueOf(0);
	}
	
	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
	public void ingresar(double cantidadSuma) {
		if(cantidadSuma>=0) {
			this.cantidad += cantidadSuma;
		}
	}
	
	public void retirar(double cantidadRetirada) {
		this.cantidad -= cantidadRetirada;
		if(this.cantidad < 0) {
			this.cantidad = Double.valueOf(0);
		}
	}
	
}
