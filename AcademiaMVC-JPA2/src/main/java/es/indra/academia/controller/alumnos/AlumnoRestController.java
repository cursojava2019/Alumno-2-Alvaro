package es.indra.academia.controller.alumnos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

@RestController
public class AlumnoRestController {
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	AlumnoFormValidator validador;
	private Logger log = LogManager.getLogger(AlumnoRestController.class);

	@Transactional
	@RequestMapping(value = "/alumnos/", method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> listar() {
		List<Alumno> listado = this.alumnoService.findAll();
		if (listado.isEmpty()) {
			return new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Alumno>>(listado, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/alumnos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> obtenerAlumno(@PathVariable("id") Long id) {

		Alumno a = this.alumnoService.find(id);

		if (a == null) {
			return new ResponseEntity<Alumno>(HttpStatus.NO_CONTENT);
		} else {
			a.getId();
			return new ResponseEntity<Alumno>(a, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/alumnos/", method = RequestMethod.POST)
	public ResponseEntity<Void> crearAlumno(@RequestBody Alumno alumno, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		this.alumnoService.create(alumno);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/alumnos/{id}").buildAndExpand(alumno.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "/alumnos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("id") long id, @RequestBody Alumno alumno) {
		System.out.println("Updating User " + id);

		Alumno currentAlumno = this.alumnoService.find(id);

		if (currentAlumno == null) {
			;
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}

		currentAlumno.setNombre(alumno.getNombre());
		currentAlumno.setApellido1(alumno.getApellido1());
		currentAlumno.setApellido2(alumno.getApellido2());
		currentAlumno.setCorreo(alumno.getCorreo());

		this.alumnoService.update(currentAlumno);
		return new ResponseEntity<Alumno>(currentAlumno, HttpStatus.OK);
	}

	@RequestMapping(value = "/alumnos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Alumno> deleteUser(@PathVariable("id") Long id) {
		Alumno currentAlumno = this.alumnoService.find(id);
		if (currentAlumno == null) {
			;
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		this.alumnoService.delete(id);
		return new ResponseEntity<Alumno>(HttpStatus.NO_CONTENT);
	}

}
