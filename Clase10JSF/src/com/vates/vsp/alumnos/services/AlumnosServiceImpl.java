package com.vates.vsp.alumnos.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vates.vsp.alumnos.business.Alumnos;
import com.vates.vsp.commons.AbstractBaseService;

@Repository("alumnosService")
public class AlumnosServiceImpl extends AbstractBaseService implements
		AlumnosService {

	@Override
	public Alumnos getAlumno(Integer id) {
		return this.get(Alumnos.class, id);
	}

	@Override
	public void guardarAlumno(Alumnos alumno) {
		this.getHibernateTemplate().saveOrUpdate(alumno);
	}

	@Override
	public void deleteAlumno(Alumnos alumno) {
		this.getHibernateTemplate().delete(alumno);
	}

	@Override
	public List<Alumnos> getAllAlumnos() {
		List<Alumnos> result = this.getHibernateTemplate().find("FROM Alumnos");
		return result;
	}

}
