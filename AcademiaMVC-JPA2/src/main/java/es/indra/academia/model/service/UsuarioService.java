package es.indra.academia.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.UsuarioDao;
import es.indra.academia.model.entities.Usuario;
import es.indra.academia.model.support.DaoException;

@org.springframework.stereotype.Service
public class UsuarioService {

	@Autowired
	UsuarioDao dao;
	private Logger log = LogManager.getLogger(UsuarioService.class);

	protected UsuarioDao getDao() {
		return this.dao;
	}

	protected Logger getLog() {
		return this.log;
	}

	public Usuario buscarUsuario(String username) {
		try {
			return this.dao.buscarUsuario(username);
		} catch (DaoException e) {
			this.log.error("Error", e);
			return null;
		}
	}

}
