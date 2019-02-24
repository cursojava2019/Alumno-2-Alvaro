package es.indra.academia.controller.profesores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorJpaService;


@Component
public class ProfesorFormValidator implements Validator {
	@Autowired
	private ProfesorJpaService profesorService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ProfesorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProfesorForm form = (ProfesorForm) target;
		
		
	if(form.getTelefono().length()!=9) {
		errors.rejectValue("telefono", "telefono.tamanio");
	}
	}

}