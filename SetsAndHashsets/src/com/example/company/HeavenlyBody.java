package com.example.company;

import java.util.*;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellite;

    protected enum BodyTypes{
        STAR,
        PLANET,
        MOON,
        COMET,
        DWARF_PLANET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType ) {

            this.key=new Key(name,bodyType);
            this.orbitalPeriod = orbitalPeriod;
            this.satellite = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatllite(HeavenlyBody moon){
        return this.satellite.add(moon);
    }

    public Set<HeavenlyBody> getSatellite() {
        return new HashSet<>(satellite);
    }

    public static Key makeKey(String name , BodyTypes bodyType) {
        return new Key(name,bodyType);
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj instanceof HeavenlyBody){
            HeavenlyBody thisobject = ((HeavenlyBody) obj);
            return this.key.equals(thisobject.getKey());
        }
        return false;
    }

    @Override
    public String toString() {
        return   this.key.getName() + " : " + this.key.getBodyType() + ", " + this.orbitalPeriod ;
    }

    public static final class Key {
        private final String name;
        private final BodyTypes bodyType;

        private Key(String name, BodyTypes bodyTypes){
            this.name=name;
            this.bodyType =bodyTypes;
        }

        public String getName() {
            return this.name;
        }

        public BodyTypes getBodyType() {
            return this.bodyType;
        }

        @Override
        public int hashCode() {
            return bodyType.hashCode()+23+this.name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.name.equals(key.name)) {
                    return this.bodyType == key.bodyType;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name +" : " +this.bodyType;
        }
    }
}