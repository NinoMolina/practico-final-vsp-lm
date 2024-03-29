package com.vates.vsp.alumnos.business;

// default package
// Generated 06-oct-2010 18:59:18 by Hibernate Tools 3.3.0.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.vates.vsp.asistencia.business.Asistencia;

/**
 * Clases generated by hbm2java
 */
public class Clases implements java.io.Serializable {

	private Integer id;
	private Date fecha;
	private String tema;
	private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);

	public Clases() {
	}

	public Clases(Date fecha, String tema) {
		this.fecha = fecha;
		this.tema = tema;
	}

	public Clases(Date fecha, String tema, Set<Asistencia> asistencias) {
		this.fecha = fecha;
		this.tema = tema;
		this.asistencias = asistencias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Set<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(Set<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

}
