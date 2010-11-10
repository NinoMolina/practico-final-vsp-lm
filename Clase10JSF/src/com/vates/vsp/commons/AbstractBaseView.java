package com.vates.vsp.commons;

/**
 * 
 * @author scerrato
 * @since 21/10/2010
 * Clase Base para Vista
 */
public abstract class AbstractBaseView {

	protected UseCaseMode useCaseMode;

	public UseCaseMode getUseCaseMode() {
		return useCaseMode;
	}

	public void setUseCaseMode(UseCaseMode useCaseMode) {
		this.useCaseMode = useCaseMode;
	}

	public boolean isModoModificacion() {
		return UseCaseMode.MODIFICACION == useCaseMode;
	}

	public boolean isModoConsulta() {
		return UseCaseMode.CONSULTA == useCaseMode;
	}

	public boolean isModoNuevo() {
		return UseCaseMode.NUEVO == useCaseMode;
	}
	
	public boolean isModoEliminacion() {
		return UseCaseMode.ELIMINACION == useCaseMode;
	}
}
