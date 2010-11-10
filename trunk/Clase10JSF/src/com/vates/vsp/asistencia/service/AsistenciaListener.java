package com.vates.vsp.asistencia.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.view.AlumnosView;
import com.vates.vsp.asistencia.view.AsistenciaView;


@ManagedBean(name = "asistenciaListener")
@SessionScoped
public class AsistenciaListener {

	@ManagedProperty(value = "#{asistenciaView}")
	private AsistenciaView asistenciaView;

	public AsistenciaView getAsistenciaView() {
		return asistenciaView;
	}

	public void setAsistenciaView(AsistenciaView asistenciaView) {
		this.asistenciaView = asistenciaView;
	}
	
	public String registrarAsistencias(){
		return "registrarAsistencias";
	}
	
}
