package com.company;

public class Vehicle {
    private String vehiclename;
    private int currentspeed;
    private int currentdirection;

    public Vehicle(String vehiclename, int currentspeed, int currentdirection) {
        this.vehiclename = vehiclename;
        this.currentspeed = currentspeed;
        this.currentdirection = currentdirection;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }

    public void setCurrentspeed(int currentspeed) {
        this.currentspeed = currentspeed;
    }

    public void setCurrentdirection(int currentdirection) {
        this.currentdirection = currentdirection;
    }

    public int getCurrentspeed() {
        return currentspeed;
    }

    public int getCurrentdirection() {
        return currentdirection;
    }
}
