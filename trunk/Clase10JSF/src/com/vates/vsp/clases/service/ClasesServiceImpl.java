package com.vates.vsp.clases.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vates.vsp.alumnos.business.Clases;
import com.vates.vsp.commons.AbstractBaseService;

@Repository("clasesService")
public class ClasesServiceImpl extends AbstractBaseService implements ClasesService{

	@Override
	public Clases getClases(Integer id) {
		return this.get(Clases.class, id);
	}

	@Override
	public void guardarClases(Clases clases) {
		this.getHibernateTemplate().saveOrUpdate(clases);
		
	}

	@Override
	public void deleteClases(Clases clases) {
		this.getHibernateTemplate().delete(clases);
		
	}

	@Override
	public List<Clases> getAllClases() {
		List<Clases> list=this.getHibernateTemplate().find("FROM Clases");
		return list;
	}

}
