package es.indra.model;

public class Cuenta {
	private static final double INTERESCC = 0.1;
	private static final double INTERESCV = 0.2;
	private static final double INTERESFI = 0.34;
	private String tipoCuenta;
	private double comision;
	private Float saldo;
	
	public Cuenta() {
		super();
		this.comision = new Double(0.6);
	}

	public Cuenta(String tipoCuenta, double comision, Float saldo) {
		super();
		this.tipoCuenta = tipoCuenta;
		this.comision = comision;
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [tipoCuenta=" + tipoCuenta + ", comision=" + comision + ", saldo=" + saldo + "]";
	}
	
	public String validarTipoCuenta(String cuenta) {
		if(cuenta.equals("Cuenta Corriente") || cuenta.equals("Cuenta Vivienda") || cuenta.equals("Fondo Inversion")) {
			return cuenta;
		} else {
			return "Cuenta sin tipo definido";
		}
	}
	
}
