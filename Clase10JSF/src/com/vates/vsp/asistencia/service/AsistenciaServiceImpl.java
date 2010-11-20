package com.vates.vsp.asistencia.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vates.vsp.asistencia.business.Asistencia;
import com.vates.vsp.commons.AbstractBaseService;

@Repository("asistenciaService")
public class AsistenciaServiceImpl extends AbstractBaseService implements
		AsistenciaService {

	@Override
	public Asistencia getAsistencia(Integer id) {

		return this.get(Asistencia.class, id);
	}

	@Override
	public void guardarAsistencia(Asistencia asistencia) {
		this.getHibernateTemplate().saveOrUpdate(asistencia);

	}

	@Override
	public void deleteAsistencia(Asistencia asistencia) {
		this.getHibernateTemplate().delete(asistencia);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asistencia> getAllAsistencia() {
		List<Asistencia> list = this.getHibernateTemplate().find(
				"FROM Asistencia");
		return list;
	}

	@Override
	public void guardarAllAsistencia(List<Asistencia> list) {
		this.getHibernateTemplate().saveOrUpdateAll(list);
	}

}
