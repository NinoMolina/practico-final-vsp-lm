package com.vates.vsp.asistencia.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.vates.vsp.alumnos.business.Alumnos;
import com.vates.vsp.alumnos.business.Clases;
import com.vates.vsp.alumnos.services.AlumnosService;
import com.vates.vsp.asistencia.business.Asistencia;
import com.vates.vsp.asistencia.view.AsistenciaView;
import com.vates.vsp.clases.service.ClasesService;
import com.vates.vsp.commons.UseCaseMode;

@ManagedBean(name = "asistenciaListener")
@SessionScoped
public class AsistenciaListener {

	@ManagedProperty(value = "#{asistenciaView}")
	private AsistenciaView asistenciaView;
	@ManagedProperty(value = "#{asistenciaService}")
	private AsistenciaService asistenciaService;
	@ManagedProperty(value = "#{clasesService}")
	private ClasesService clasesService;
	@ManagedProperty(value = "#{alumnosService}")
	private AlumnosService alumnosService;

	public AlumnosService getAlumnosService() {
		return alumnosService;
	}

	public void setAlumnosService(AlumnosService alumnosService) {
		this.alumnosService = alumnosService;
	}

	public AsistenciaView getAsistenciaView() {
		return asistenciaView;
	}

	public AsistenciaService getAsistenciaService() {
		return asistenciaService;
	}

	public void setAsistenciaService(AsistenciaService asistenciaService) {
		this.asistenciaService = asistenciaService;
	}

	public ClasesService getClasesService() {
		return clasesService;
	}

	public void setClasesService(ClasesService clasesService) {
		this.clasesService = clasesService;
	}

	public void setAsistenciaView(AsistenciaView asistenciaView) {
		this.asistenciaView = asistenciaView;
	}

	public String registrarAsistencias() {
		// if(asistenciaView.getLstClases()==null){
		// List<Clases> array=new ArrayList<Clases>();
		// asistenciaView.setLstClases(array);
		// }
		// Clases clase=new Clases(new Date(), "JSF 2.0");
		// clase.setId(1);
		// asistenciaView.getLstClases().add(clase);
		asistenciaView.setUseCaseMode(UseCaseMode.NUEVO);
		asistenciaView.setClaseSeleccionada(new Clases());
		asistenciaView.setLstAsistentes(new ArrayList<Integer>());
		asistenciaView.setLstAlumnos(alumnosService.getAllAlumnos());
		asistenciaView.setLstClases(clasesService.getAllClases());
		return "registrarAsistencias";
	}

	public void guardarAsistencia() {

		try {
			List<Alumnos> lstAlumnos = asistenciaView.getLstAlumnos();
			List<Integer> lstAsistentes = asistenciaView.getLstAsistentes();
			Clases claseSeleccionada = asistenciaView.getClaseSeleccionada();
			List<Asistencia> lstAsistencia = new ArrayList<Asistencia>();
			for (Alumnos alumno : lstAlumnos) {
				if (contieneAlumno(lstAsistentes,alumno.getId())) {
					lstAsistencia.add(new Asistencia(alumno, claseSeleccionada,
							1));
				} else {
					lstAsistencia.add(new Asistencia(alumno, claseSeleccionada,
							0));
				}
			}
			asistenciaService.guardarAllAsistencia(lstAsistencia);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean contieneAlumno(List<Integer> lista, Integer id){
		if(id==null)return false;
		Iterator it=lista.iterator();
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();	
		}
		return false;
	}

	public void setClaseSeleccionada(AjaxBehaviorEvent event) {
		Clases claseSeleccionada = asistenciaView.getClaseSeleccionada();
		asistenciaView.setClaseSeleccionada(clasesService
				.getClases(claseSeleccionada.getId()));
	}

}
