package com.vates.vsp.alumnos.business;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.vates.vsp.alumnos.view.AlumnosView;
import com.vates.vsp.commons.ListDataModel;
import com.vates.vsp.commons.UseCaseMode;

/**
 * 
 * @author scerrato
 * @since 21/10/2010 Capa de Negocio
 */
@ManagedBean(name = "alumnosListener")
@SessionScoped
public class AlumnosListener {

	@ManagedProperty(value = "#{alumnosView}")
	private AlumnosView alumnosView;

	public AlumnosView getAlumnosView() {
		return alumnosView;
	}

	public void setAlumnosView(AlumnosView alumnosView) {
		this.alumnosView = alumnosView;
	}

	public String mostrarAlumno() {
		alumnosView.setUseCaseMode(UseCaseMode.CONSULTA);
		alumnosView.setAlumno(alumnosView.getLstAlumnos().getRowData());
		return "alumno";
	}
	
	public String nuevoAlumno(){
		alumnosView.setUseCaseMode(UseCaseMode.NUEVO);
		alumnosView.setAlumno(new Alumnos());
		return "alumno";
	}
	
	public String guardarAlumno(){
		if(alumnosView.getLstAlumnos()==null){	
			List<Alumnos> array=new ArrayList<Alumnos>();
			ListDataModel<Alumnos> list=new ListDataModel<Alumnos>(array);
			alumnosView.setLstAlumnos(list);
		}
		alumnosView.getLstAlumnos().getWrappedData().add(new Alumnos());
		return null;
	}
	
	public String eliminarAlumno(){
		alumnosView.setUseCaseMode(UseCaseMode.ELIMINACION);
		alumnosView.setAlumno(alumnosView.getLstAlumnos().getRowData());
		return "alumno";
	}
	
	public String modificarAlumno(){
		alumnosView.setUseCaseMode(UseCaseMode.MODIFICACION);
		alumnosView.setAlumno(alumnosView.getLstAlumnos().getRowData());
		return "alumno";
	}
	public String listarAlumnos(){
		if(alumnosView.getLstAlumnos()==null){	
			List<Alumnos> array=new ArrayList<Alumnos>();
			ListDataModel<Alumnos> list=new ListDataModel<Alumnos>(array);
			alumnosView.setLstAlumnos(list);
		}
		List<Alumnos> array=alumnosView.getLstAlumnos().getWrappedData();
		array.add(new Alumnos("YO", "YO"));
		ListDataModel<Alumnos> list=new ListDataModel<Alumnos>(array);
		alumnosView.setLstAlumnos(list);
		return "listadoAlumnos";
	}


	public String salir() {
		return "exit";
	}
}
