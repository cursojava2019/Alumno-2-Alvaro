package es.indra.controller;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;

public class Banco implements Serializable {
	private TreeMap<String, Cliente> cliente;
	private TreeMap<String, Cuenta> cuenta;

	public Banco() {
		super();
		this.cliente = new TreeMap<String, Cliente>();
		this.cuenta = new TreeMap<String, Cuenta>();
	}

	public TreeMap<String, Cliente> getCliente() {
		return this.cliente;
	}

	public void setCliente(TreeMap<String, Cliente> cliente) {
		this.cliente = cliente;
	}

	public TreeMap<String, Cuenta> getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(TreeMap<String, Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
	
	

	@Override
	public String toString() {
		return "Banco [cliente=" + cliente + ", cuenta=" + cuenta + "]";
	}

	public Cliente obtenerCliente(String dni) {
		return this.cliente.get(dni);
	}

	public Cuenta obtenerCuenta(String numero) {
		return this.cuenta.get(numero);
	}

	public Boolean introducirCliente(Cliente c) {
		this.cliente.put(c.getDni(), c);
		return true;
	}

	public Boolean crearCuenta(Cuenta c) {
		this.cuenta.put(c.getId(), c);
		return true;
	}

	public Cuenta realizarIngreso(String dni, String id, Float cantidad) {
		Float s;
		Cliente cliente = this.cliente.get(dni);
		Cuenta cuenta = this.cuenta.get(id);
		if (cliente != null && cuenta != null && cuenta.getCliente().equals(cliente)) {
			s = cuenta.getSaldo() + cantidad;
			cuenta.setSaldo(s);
			return cuenta;
		} else {
			return null;
		}
	}

	public Cuenta sacarDinero(String dni, String codigo, Float cantidad) {
		Float s;
		Cliente cliente = this.cliente.get(dni);
		Cuenta cuenta = this.cuenta.get(codigo);
		if (cliente != null && cuenta != null && cuenta.getCliente().equals(cliente) && comprobarOperacion(codigo,cantidad, cuenta.getTipocuenta())) {
		     	s = cuenta.getSaldo() - cantidad;
		     	cuenta.setSaldo(s);
			    return cuenta;		  
		} 
		else {
			return null;
		}
	}

	public Cuenta revisionMensual(String dni, String codigo) {
		Cliente cliente = this.cliente.get(dni);
		Cuenta cuenta = this.cuenta.get(codigo);
		if (cliente != null && cuenta != null && cuenta.getCliente().equals(cliente)) {
			cuenta.revisionMensual();
			return cuenta;
		} else {
			return null;
		}
	}
	
	public Boolean comprobarOperacion(String codigo, Float cantidad, String tipoCuenta) {
		boolean b = true;
		Cuenta cuenta = this.cuenta.get(codigo);
		if (tipoCuenta.equalsIgnoreCase("CC")) {
			if( (cuenta.getSaldo() - cantidad) < 0) {
				System.out.println("No se puede sacar mas dinero del que hay");
				b=false;
			}
		}
		
	   if (tipoCuenta.equalsIgnoreCase("CV")) {
				System.out.println("No se puede sacar dinero en este tipo de cuenta");
				b=false;		
		}
		
	   if (tipoCuenta.equalsIgnoreCase("FI")) {
		   if( ( cuenta.getSaldo() - cantidad) < (float) -500) { 
			 System.out.println("No se puede sobrepasar el limite de -500€");
			 b=false;
		   }	
		}
		return b;
	}
}
