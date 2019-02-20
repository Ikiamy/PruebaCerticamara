package com.certicamara.test.model;

public class MovementsResponse {

	private String movements;
	private String error;

	public MovementsResponse(String movements, String error) {
		this.movements = movements;
		this.error = error;
	}

	public String getMovements() {
		return movements;
	}

	public void setMovements(String movements) {
		this.movements = movements;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
