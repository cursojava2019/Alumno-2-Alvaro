package es.indra.academia.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.indra.academia.model.entities.Alumno;

@Repository
public interface AlumnoDao extends JpaRepository<Alumno, Long> {

	@Query(value = "SELECT a FROM Alumno a WHERE a.nombre like %?1% or a.apellido1 like %?1% or a.apellido2 like %?1%")
	public List<Alumno> findAlumnosPatron(String patron);

	public List<Alumno> findByNifEquals(String nif);
}
