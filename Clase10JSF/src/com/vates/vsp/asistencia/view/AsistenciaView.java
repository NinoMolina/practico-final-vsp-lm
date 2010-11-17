package com.vates.vsp.asistencia.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.business.Alumnos;
import com.vates.vsp.alumnos.business.Clases;
import com.vates.vsp.asistencia.business.Asistencia;
import com.vates.vsp.commons.AbstractBaseView;
import com.vates.vsp.commons.ListDataModel;

@ManagedBean(name = "asistenciaView")
@SessionScoped
public class AsistenciaView extends AbstractBaseView{

	private Asistencia asistencia;
	private ListDataModel<Alumnos> lstAlumnos;
	private List<Clases> lstClases;
	private List<Integer> lstAsistentes;
	private Clases claseSeleccionada;
	public Asistencia getAsistencia() {
		return asistencia;
	}

	public Clases getClaseSeleccionada() {
		return claseSeleccionada;
	}

	public void setClaseSeleccionada(Clases claseSeleccionada) {
		this.claseSeleccionada = claseSeleccionada;
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

	public List<Clases> getLstClases() {
		return lstClases;
	}

	public void setLstClases(List<Clases> lstClases) {
		this.lstClases = lstClases;
	}

	public List<Integer> getLstAsistentes() {
		return lstAsistentes;
	}

	public void setLstAsistentes(List<Integer> lstAsistentes) {
		this.lstAsistentes = lstAsistentes;
	}
	
	
}
