package es.indra.model.entities;

import java.io.Serializable;

public class Cuenta implements Serializable{
	
	public static Float COMISION_DEFECTO =  (float) 0.6;
	public static String CUENTA_CORRIENTE="CC";
	public static String CUENTA_VIVIENDA="CV";
	public static String FONDO_INVERSION="FI";
	
	private String id;
	private Float comision;
	private String tipocuenta;
	private Float saldo;
	private String dnicliente;
	
	public Cuenta() {
		super();
	}

	public Cuenta(String id, Float comision, String tipocuenta, Float saldo, String dnicliente) {
		super();
		this.id = id;
		this.comision = comision;
		this.tipocuenta = tipocuenta;
		this.saldo = saldo;
		this.dnicliente = dnicliente;
	}
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getComision() {
		return comision;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}

	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", comision=" + comision + ", tipocuenta=" + tipocuenta
				+ ", saldo=" + saldo + "]";
	}

	public Float interes(String tipocuenta) {
		Float aux = (float) 0;
		if (tipocuenta.equalsIgnoreCase("CC")) {
			aux = (float) 0.1;
			return aux;
		} else if (tipocuenta.equalsIgnoreCase("CV")) {
			aux = (float) 0.2;
			return aux;
		} else {
			aux = (float) 0.34;
			return aux;
		}
	}
	
	public void revisionMensual() {
		Float s = (float) 0;
		s = getSaldo()* this.interes(this.tipocuenta) - this.comision;
		setSaldo(s);
		System.out.println("Revision mensual realizada");
	}
}