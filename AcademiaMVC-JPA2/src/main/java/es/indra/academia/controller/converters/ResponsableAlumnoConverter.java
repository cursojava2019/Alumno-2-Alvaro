package es.indra.academia.controller.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.indra.academia.model.entities.ResponsableAlumno;

@Component
public class ResponsableAlumnoConverter implements Converter<Long, ResponsableAlumno> {

	@Override
	public ResponsableAlumno convert(Long source) {
		// TODO Pendiente implementar el servicio y obtener de él el responsable
		ResponsableAlumno responsable = new ResponsableAlumno();
		responsable.setId(source);
		return responsable;
	}

}
