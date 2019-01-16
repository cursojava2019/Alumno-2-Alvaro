package es.indra.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class Banco {
	private TreeMap<String,Cliente>clientes;
	
	public Banco() {
		super();
	}

	public Banco(TreeMap<String, Cliente> clientes) {
		super();
		this.clientes = clientes;
	}
	
	
}
