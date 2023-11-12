package com.company;

public class Car extends Vehicle {
    private int seat;
    private String type;
    private int gear;

    public Car( int currentspeed, int currentdirection, int seat, String type, int gear) {
        super("Car", currentspeed, currentdirection);
        this.seat = seat;
        this.type = type;
        this.gear = gear;
    }

    public int getSeat() {
        return seat;
    }

    public String getType() {
        return type;
    }

    public int getgear() {
        return gear;
    }

    public void setgear(int gear) {
        this.gear = gear;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setType(String type) {
        this.type = type;
    }
}
