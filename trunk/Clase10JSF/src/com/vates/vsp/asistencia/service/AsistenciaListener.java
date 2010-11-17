package com.vates.vsp.asistencia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.business.Clases;
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
		if(asistenciaView.getLstClases()==null){
			List<Clases> array=new ArrayList<Clases>();
			asistenciaView.setLstClases(array);
		}
		Clases clase=new Clases(new Date(), "JSF 2.0");
		clase.setId(1);
		asistenciaView.getLstClases().add(clase);
		return "registrarAsistencias";
	}
	
}
