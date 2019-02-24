package es.indra.academia.controller.alumnos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

public class AlumnoRest {
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
	private Date fechaAlta;

	private Date fechaBaja;
	@Size(min = 0, max = 500)
	private String observaciones;
	private Long idResponsable;
	
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
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Boolean getRepetidor() {
		return repetidor;
	}
	public void setRepetidor(Boolean repetidor) {
		this.repetidor = repetidor;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Long getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}
	
	
}