package com.company;

public class dog extends animal { //extends is a keyword in java to inherite a class
                                  //and all it methods
    private  int eyes;
    private  int legs;
    private int teeth;
    private  int tail;
    public dog(String name, int size, int weight, int eyes, int legs , int teeth, int tail) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.teeth = teeth;
        this.legs = legs;
        this.tail = tail;
    }

}
