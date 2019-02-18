package es.indra.academia.model.support;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class Service<K extends Serializable, O> {

	protected abstract JpaRepository<O, K> getDao();

	protected abstract Logger getLog();

	public void create(O entity) {
		try {
			getLog().info("Creando Objeto");
			getDao().save(entity);
		} catch (Exception e) {
			getLog().error("Error al crear en base de datos " + entity.getClass().getName());
		}
	}

	public void update(O entity) {
		try {
			getLog().info("Actualizando Objeto");
			getDao().save(entity);
		} catch (Exception e) {
			getLog().error("Error al modificar en base de datos " + entity.getClass().getName());
		}
	}

	public void delete(K key) {
		try {
			getLog().info("borrando Objeto");
			getDao().delete(key);
		} catch (Exception e) {
			getLog().error("Error al eliminar en base de datos ");
		}
	}

	public O find(K key) {
		try {
			getLog().info("buscando");
			O entidad = getDao().getOne(key);
			return entidad;
		} catch (Exception e) {
			getLog().error("Error Al realizar la busqueda ");
			return null;
		}
	}

	public List<O> findAll() {
		try {
			getLog().info("Obtener todos");
			return getDao().findAll();
		} catch (Exception e) {
			getLog().error("Error Al realizar la busqueda ");
			return null;
		}

	}

	public Page<O> findAllPaginado(Integer numeroPagina, Integer tamanioPagina) {
		try {
			getLog().info("Obtener todos Paginado");
			Pageable request = new PageRequest(numeroPagina, tamanioPagina);
			return getDao().findAll(request);
		} catch (Exception e) {
			getLog().error("Error Al realizar la busqueda ");
			return null;
		}

	}
}
