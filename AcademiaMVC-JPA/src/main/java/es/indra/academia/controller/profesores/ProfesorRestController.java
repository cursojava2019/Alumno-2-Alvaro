package es.indra.academia.controller.profesores;

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

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorService;

@RestController
public class ProfesorRestController {
	@Autowired
	private ProfesorService profesorService;
	@Autowired
	ProfesorFormValidator validador;
	private Logger log = LogManager.getLogger(ProfesorRestController.class);

	@Transactional
	@RequestMapping(value = "/profesores/", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar() {
		List<Profesor> listado = this.profesorService.findAll();
		if (listado.isEmpty()) {
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Profesor>>(listado, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerProfesor(@PathVariable("id") Long id) {

		Profesor p = this.profesorService.find(id);

		if (p == null) {
			return new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
		} else {
			p.getId();
			return new ResponseEntity<Profesor>(p, HttpStatus.OK);
		}
	}

	@Transactional
	@RequestMapping(value = "/profesores/", method = RequestMethod.POST)
	public ResponseEntity<Void> crearProfesor(@RequestBody Profesor profesor, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		this.profesorService.create(profesor);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/profesores/{id}").buildAndExpand(profesor.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") long id, @RequestBody Profesor profesor) {
		System.out.println("Updating User " + id);

		Profesor currentProfesor = this.profesorService.find(id);

		if (currentProfesor == null) {
			;
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}

		currentProfesor.setNombre(profesor.getNombre());
		currentProfesor.setApellido1(profesor.getApellido1());
		currentProfesor.setApellido2(profesor.getApellido2());
		currentProfesor.setCorreo(profesor.getCorreo());

		this.profesorService.update(currentProfesor);
		return new ResponseEntity<Profesor>(currentProfesor, HttpStatus.OK);
	}

	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Profesor> deleteUser(@PathVariable("id") Long id) {
		Profesor currentProfesor = this.profesorService.find(id);
		if (currentProfesor == null) {
			;
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		this.profesorService.delete(id);
		return new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
	}

}