package es.indra.controller;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;
import es.indra.model.service.ClienteService;
import es.indra.model.service.CuentaService;

public class Banco implements Serializable {
	ClienteService clienteService;
	CuentaService cuentaService;
	private TreeMap<String, Cliente> cliente;
	private TreeMap<String, Cuenta> cuenta;

	public Banco() {
		super();
		this.cliente = new TreeMap<String, Cliente>();
		this.cuenta = new TreeMap<String, Cuenta>();
		this.clienteService = new ClienteService();
		this.cuentaService = new CuentaService();
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

	public Cuenta obtenerCuenta(String dni,String id) {
		Cuenta c = null;
		
		if (this.cuentaService.find(id) != null && this.cuentaService.find(id).getDnicliente().equals(dni)) {
			c = this.cuentaService.find(id);

		}
		return c;
	}

	public Boolean introducirCliente(Cliente c) {
		this.clienteService.create(c);
		return true;
	}

	public Boolean crearCuenta(Cuenta c) {
		this.cuentaService.create(c);
		return true;
	}

	public Cuenta realizarIngreso(Cuenta c,Float cantidad) {
		if(c.getTipocuenta().equals("CC")) {	  
			   c=this.cuentaService.aniadirSaldoService(c,cantidad);
			   if(c != null) {
				   this.cuentaService.update(c);
			   }else {
				   System.out.println("Ha habido algun error al ingresar el dinero");
			   }
			  
		  }
		return c;
	}

	public Cuenta sacarDinero(Cuenta c,Float cantidad) {
		if(c.getTipocuenta().equals("CC")) {	  
			   c=this.cuentaService.retirarSaldoService(c,cantidad);
			   if(c != null) {
				   this.cuentaService.update(c);
			   }else {
				   System.out.println("Ha habido algun error al retirar el dinero");
			   }
			  
		  }
		return c;
	}

	public Cuenta forzarRevisionMensual(Cuenta c) {	  
		c=this.cuentaService.forzarRevision(c);
		if(c != null) {
			this.cuentaService.update(c);
			} else {
				System.out.println("Ha habido algun error al realizar la revision mensual");
			}
		return c;
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
