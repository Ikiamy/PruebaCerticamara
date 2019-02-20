package com.certicamara.test.exception;

public class OutLimitsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Se ha detenido el avance por salir de los limites";
	}
}
