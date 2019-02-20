package com.certicamara.test.exception;

public class SurfaceNotInitializedException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
    public String getMessage(){
        return "La superficie no ha sido inicializada";
    }
}
