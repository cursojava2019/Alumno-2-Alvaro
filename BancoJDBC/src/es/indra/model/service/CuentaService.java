package es.indra.model.service;

import java.util.List;

import es.indra.model.dao.CuentaDao;
import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class CuentaService extends Service<Long, Cuenta> {

	private CuentaDao dao = null;

	@Override
	protected Dao<Long, Cuenta> getDao() {
		if (this.dao == null) {
			this.dao = new CuentaDao();
		}
		return this.dao;
	}
	
	public Cuenta aniadirSaldoService(Cuenta cuenta, Float cantidad) {
		Float saldoActual = cuenta.getSaldo();
		cuenta.setSaldo(saldoActual+cantidad);
		return cuenta;
	}
	
	public Cuenta retirarSaldoService(Cuenta cuenta, Float cantidad) {
		Float saldoActual = cuenta.getSaldo();
		cuenta.setSaldo(saldoActual-cantidad);
		return cuenta;	
	}
	
	public Cuenta forzarRevision(Cuenta cuenta) {
		Float saldoActual = cuenta.getSaldo();
		cuenta.setSaldo(saldoActual+cuenta.getComision()-(float)0.6);
		return cuenta;	
	}
	
	/*public List<Cuenta> findCuentas(){
		return null;
	}*/

}