package com.vates.vsp.asistencia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.business.Alumnos;
import com.vates.vsp.asistencia.business.Asistencia;
import com.vates.vsp.commons.AbstractBaseView;
import com.vates.vsp.commons.ListDataModel;

@ManagedBean(name = "asistenciaView")
@SessionScoped
public class AsistenciaView extends AbstractBaseView{

	private Asistencia asistencia;
	private ListDataModel<Alumnos> lstAlumnos;
	public Asistencia getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public ListDataModel<Alumnos> getLstAlumnos() {
		return lstAlumnos;
	}

	public void setLstAlumnos(ListDataModel<Alumnos> lstAlumnos) {
		this.lstAlumnos = lstAlumnos;
	}
	
	
}
