package com.vates.vsp.asistencia.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vates.vsp.asistencia.business.Asistencia;

public interface AsistenciaService {

	public abstract Asistencia getAsistencia(Integer id);

    @Transactional
    public abstract void guardarAsistencia(Asistencia asistencia);

    @Transactional
    public abstract void deleteAsistencia(Asistencia asistencia);
    
    public abstract List<Asistencia> getAllAsistencia();
    
    public void guardarAllAsistencia(List<Asistencia> list);
}
