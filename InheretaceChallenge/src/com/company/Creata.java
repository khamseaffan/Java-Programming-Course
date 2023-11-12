package com.company;

public class Creata extends Car {
    private String colour;
    private String model;

    public Creata(int currentspeed, int currentdirection, int gear, String colour, String model) {
        super(currentspeed, currentdirection, 5, "SUV", gear);
        this.colour = colour;
        this.model = model;
    }

    public void changear(int gear){
        super.setgear(gear);
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }
    public void getcarinfo(){
        System.out.println("\t\tVehiocle Name = " + getVehiclename());
        System.out.println("Car name = Creata \n Model = "+ this.model + "\n colour = "+ this.colour );
        System.out.println("type = " + getType() + " \n seat = "+ getSeat());
        System.out.println("Current speed = " +getCurrentspeed());
        System.out.println("curret Direction "+ getCurrentdirection());
    }
}
