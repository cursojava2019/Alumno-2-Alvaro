package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.AlumnoJpaDao;
//import es.indra.academia.model.dao.ReponsableDao;
import es.indra.academia.model.dao.ResponsableJpaDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class ResponsableJpaService extends ServiceJpa<Long,ResponsableAlumno>{
	
	//private Logger log = LogManager.getLogger(ResponsableJpaService.class);
	
	@Autowired
	private ResponsableJpaDao dao;
	@Autowired
	private AlumnoJpaDao dao2;

	@Override
	public JpaDao<Long, ResponsableAlumno> getDao() {
		return this.dao;
	}

	
	public List<ResponsableAlumno> findResponsableAlumnosPatron(String patron) {
	
			return this.dao.findResponsableAlumnosPatron(patron);
			//Falta catch y Try !!

	}

/*	@Override
	protected Logger getLog() {
		return this.log;

	}*/

	public List<ResponsableAlumno> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			//this.log.error("Error buscando NIF", e);
			return null;
		}
	}
	
	
	public List<ResponsableAlumno> norepe (ResponsableAlumno a) throws ServiceException, DaoException{
		List<ResponsableAlumno> listado2 = this.dao.findAll();
		
		Long id=a.getId();
		int n=listado2.size();
		for(int i=0;i<n;i++) {
			if(id==listado2.get(i).getId()) {
				listado2.remove(listado2.get(i));
			}
		}
		
		
		return  listado2;
	}
	
	public void eliminarbien (ResponsableAlumno a) {
		List<Alumno> alumnos=a.getAlumnos();
		int n=alumnos.size();
		for(int i=0;i<n;i++) {
			Alumno al=alumnos.get(i);
			al.setResponsableAlumno(null);
			this.dao2.update(al);
		}
		this.dao.deleteById(a.getId());
	}
	
}
