package es.indra.model.service;

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
		return (Dao<Long, Cuenta>) this.dao;
	}

}