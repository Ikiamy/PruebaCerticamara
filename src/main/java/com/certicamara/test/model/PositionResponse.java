package com.certicamara.test.model;

public class PositionResponse {

    private Coords position;
    private String error;

    public PositionResponse(Coords position, String error) {
        this.position = position;
        this.error = error;
    }

    public Coords getPosition() {
        return position;
    }

    public void setPosition(Coords position) {
        this.position = position;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
