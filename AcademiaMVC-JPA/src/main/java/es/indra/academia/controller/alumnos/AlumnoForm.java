package es.indra.academia.controller.alumnos;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

public class AlumnoForm {
	@Positive
	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nombre;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String apellido1;
	private String apellido2;
	@Size(min = 9, max = 9)
	private String nif;
	
	private String telefono;
	@Email
	@NotEmpty
	private String correo;
	private Boolean repetidor;
	@PastOrPresent
	private Timestamp fechaalta;

	private Timestamp fechabaja;
	@Size(min = 0, max = 500)
	private String observaciones;
	private ResponsableAlumno responsable;
	
	public AlumnoForm() {
		super();
		this.nif = "";
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.telefono = "";
		this.correo = "";
		this.observaciones = "";
		this.repetidor = false;
	}

	public AlumnoForm(Alumno a) {
		super();
		this.id = a.getId();
		this.nif = (a.getNif());
		this.nombre = (a.getNombre());
		this.apellido1 = (a.getApellido1());
		this.apellido2 = (a.getApellido2());
		this.telefono = (a.getTelefono());
		this.correo = (a.getCorreo());
		this.observaciones = (a.getObservaciones());
		this.repetidor = (a.getRepetidor());
		this.responsable=(a.getResponsableAlumno());
		//this.fechaAlta = (a.getFechaAlta());
		//this.fechaBaja = (a.getFechaBaja());
	}

	public Alumno obtenerAlumno() throws ServiceException, DaoException {
		Alumno a = new Alumno();
		a.setId(getId());
		a.setNif(getNif());
		a.setNombre(getNombre());
		a.setApellido1(getApellido1());
		a.setApellido2(getApellido2());
		a.setTelefono(getTelefono());
		a.setCorreo(getCorreo());
		a.setObservaciones(getObservaciones());
		a.setRepetidor(getRepetidor());
		a.setResponsableAlumno(getResponsable());
		
		return a;
	}
	public Alumno obtenernuevoalumno() throws ServiceException, DaoException {
		Alumno a = new Alumno();
		a.setId(getId());
		a.setNif(getNif());
		a.setNombre(getNombre());
		a.setApellido1(getApellido1());
		a.setApellido2(getApellido2());
		a.setTelefono(getTelefono());
		a.setCorreo(getCorreo());
		a.setObservaciones(getObservaciones());
		a.setRepetidor(getRepetidor());
		return a;
	}
	
	public void actualizar (Alumno a) {
		a.setId(getId());
		a.setNif(getNif());
		a.setNombre(getNombre());
		a.setApellido1(getApellido1());
		a.setApellido2(getApellido2());
		a.setTelefono(getTelefono());
		a.setCorreo(getCorreo());
		a.setObservaciones(getObservaciones());
		a.setFechaalta(getFechaalta());
		a.setFechabaja(getFechabaja());
		a.setRepetidor(getRepetidor());
		a.setResponsableAlumno(getResponsable());
		
	}

//	public void validar(List<String> errores) {
//		if (nif == null || nif.equals("")) {
//			errores.add("El nif es obligatorio");
//
//		}
//		if (nif.length() != 9) {
//			errores.add("El formato de NIF no es correcto");
//
//		}
//		if (nombre=() == null || getNombre().equals("")) {
//			errores.add("El Nombre es obligatorio");
//
//		}
//		if (getApellido1() == null || getApellido1().equals("")) {
//			errores.add("El Primero Apellido es obligatorio");
//
//		}
//
//	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getRepetidor() {
		return this.repetidor;
	}

	public void setRepetidor(Boolean repetidor) {
		this.repetidor = repetidor;
	}

	public Timestamp getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Timestamp fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Timestamp getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Timestamp fechabaja) {
		this.fechabaja = fechabaja;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

/*	public String getFechaAltaString() {
		if (this.fechaAlta != null) {
			return Long.toString(this.fechaAlta.getTime());
		} else {
			return "";
		}
	}

	public String getFechaBajaString() {
		if (this.fechaBaja != null) {
			return Long.toString(this.fechaBaja.getTime());
		} else {
			return "";
		}
	}*/

	
	public ResponsableAlumno getResponsable() {
		return responsable;
	}

	public void setResponsable(ResponsableAlumno responsable) {
		this.responsable = responsable;
	}

	/*public void setFechaAltaString(String fechaString) {
		Long timeStamp = Long.parseLong(fechaString);
		this.fechaAlta = (new Date(timeStamp));

	}

	public void setFechaBajaString(String fechaString) {
		Long timeStamp = Long.parseLong(fechaString);
		this.fechaBaja = (new Date(timeStamp));

	}*/
}
