package com.example.company;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatllite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatllite(moon);
        }
        else return false;
    }
}
