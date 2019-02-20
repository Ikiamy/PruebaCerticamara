package com.certicamara.test.model;

public class Surface {

    private Coords gridSize;
    private Coords vehiclePosition;
    private StringBuffer movements;

    public Surface(){}

    public Surface(int n, int m) {
        this.gridSize = new Coords(n, m);
        this.vehiclePosition = new Coords(0, 0);
        this.movements = new StringBuffer();
    }

    public void setVehiclePosition(Coords c){
        this.vehiclePosition = c;
    }

    public void setVehiclePosition(int x, int y){
        this.vehiclePosition = new Coords(x, y);
    }

    public Coords getVehiclePosition(){
        return this.vehiclePosition;
    }

    public Coords getGridSize(){
        return this.gridSize;
    }

    public int getM(){
        return this.gridSize.getX();
    }

    public int getN(){
        return this.gridSize.getY();
    }

    public void setM(int m){
        this.gridSize.setX(m);
    }

    public void setN(int n){
        this.gridSize.setY(n);
    }

    public int getVehicleX(){
        return this.vehiclePosition.getX();
    }

    public int getVehicleY(){
        return this.vehiclePosition.getY();
    }

    public void setVehicleX(int x){
        this.vehiclePosition.setX(x);
    }

    public void setVehicleY(int y){
        this.vehiclePosition.setY(y);
    }

	public StringBuffer getMovements() {
		return movements;
	}

	public void setMovements(StringBuffer movements) {
		this.movements = movements;
	}
}
