package com.vates.vsp.alumnos.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.vates.vsp.alumnos.services.AlumnosService;
import com.vates.vsp.alumnos.services.AlumnosServiceImpl;
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
	@ManagedProperty(value = "#{alumnosService}")
    private AlumnosService alumnosService;


	public AlumnosService getAlumnosService() {
		return alumnosService;
	}

	public void setAlumnosService(AlumnosService alumnosService) {
		this.alumnosService = alumnosService;
	}

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
		
//		if(alumnosView.getLstAlumnos()==null){	
//			List<Alumnos> array=new ArrayList<Alumnos>();
//			ListDataModel<Alumnos> list=new ListDataModel<Alumnos>();
//			alumnosView.setLstAlumnos(list);
//		}
//		List<Alumnos> array=alumnosView.getLstAlumnos().getWrappedData();
//		array.add(new Alumnos("YO", "YO"));
		alumnosView.setUseCaseMode(UseCaseMode.CONSULTA);
        List<Alumnos> resultado = alumnosService.getAllAlumnos();
        if(resultado==null){
        	resultado=new ArrayList<Alumnos>();
        }
        alumnosView.setLstAlumnos(new ListDataModel<Alumnos>(resultado));
		return "listadoAlumnos";
	}


	public String salir() {
		return "exit";
	}
}
