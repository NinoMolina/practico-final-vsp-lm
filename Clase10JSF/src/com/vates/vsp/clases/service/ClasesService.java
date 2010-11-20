package com.vates.vsp.clases.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vates.vsp.alumnos.business.Clases;

public interface ClasesService {
	public abstract Clases getClases(Integer id);

    @Transactional
    public abstract void guardarClases(Clases clases);

    @Transactional
    public abstract void deleteClases(Clases clases);
    
    public abstract List<Clases> getAllClases();
}
