package com.vates.vsp.commons;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AbstractBaseService extends HibernateDaoSupport {
	
	public AbstractBaseService() {
		super();
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> type, Serializable id) {
		return (T) this.getHibernateTemplate().get(type, id);
	}
	

	@Override
	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {

		HibernateTemplate template = super
				.createHibernateTemplate(sessionFactory);
		template.setFlushMode(HibernateTemplate.FLUSH_COMMIT);
		return template;
	}

}
