package com.vates.vsp.alumnos.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vates.vsp.alumnos.business.Alumnos;

public interface AlumnosService {
	public abstract Alumnos getAlumno(Integer id);

        @Transactional
        public abstract void guardarAlumno(Alumnos alumno);

        @Transactional
        public abstract void deleteAlumno(Alumnos alumno);
        
        public abstract List<Alumnos> getAllAlumnos();

}
