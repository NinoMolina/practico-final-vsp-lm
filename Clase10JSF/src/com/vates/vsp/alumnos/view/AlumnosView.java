package com.vates.vsp.alumnos.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.business.Alumnos;
import com.vates.vsp.commons.AbstractBaseView;
import com.vates.vsp.commons.ListDataModel;

/**
 * 
 * @author scerrato
 * @since 21/10/2010 Capa de Vista
 */
@ManagedBean(name = "alumnosView")
@SessionScoped
public class AlumnosView extends AbstractBaseView {

	private Alumnos alumno;
	private ListDataModel<Alumnos> lstAlumnos;
	public Alumnos getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

	public ListDataModel<Alumnos> getLstAlumnos() {
		return lstAlumnos;
	}
	
	public List<Alumnos> getAlumnos(){
		return lstAlumnos.getWrappedData();
	}

	public void setLstAlumnos(ListDataModel<Alumnos> lstAlumnos) {
		this.lstAlumnos = lstAlumnos;
	}

}
