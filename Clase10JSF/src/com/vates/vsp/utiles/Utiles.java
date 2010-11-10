package com.vates.vsp.utiles;

import javax.faces.context.FacesContext;

public class Utiles {

	public static FacesContext getContext() {
		return  FacesContext.getCurrentInstance();
	}
	
	public static Object getBean(String beanName) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getSessionMap().get(beanName);
	}
}
