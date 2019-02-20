package com.certicamara.test.exception;

public class CommandParseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
    public String getMessage(){
        return "Error en formato de comando";
    }
	
}
