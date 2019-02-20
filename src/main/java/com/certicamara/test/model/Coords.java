package com.certicamara.test.model;

import javax.validation.constraints.NotNull;

public class Coords {

    @NotNull
    private Integer x;
    @NotNull
    private Integer y;
    
    private String movements;

    public Coords() {
    }

    public Coords(@NotNull Integer x, @NotNull Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

	public String getMovements() {
		return movements;
	}

	public void setMovements(String movements) {
		this.movements = movements;
	}
}
