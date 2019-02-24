package es.indra.academia.controller.responsable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;

@Component
public class ResponsableFormValidator implements Validator {
	@Autowired
	private ResponsableJpaService responsableService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ResponsableForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ResponsableForm form = (ResponsableForm) target;
		
		if(form.getTelefono().length()!=9) {
			errors.rejectValue("telefono", "telefono.tamanio");
		}
	}

}
