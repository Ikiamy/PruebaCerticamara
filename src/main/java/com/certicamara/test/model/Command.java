package com.certicamara.test.model;

public class Command {

    public enum Direction {
        NORTH, SOUTH, WEST, EAST
    }

    private Direction direction;
    private int amount;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
