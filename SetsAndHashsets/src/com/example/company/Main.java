package com.example.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets =new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp  = new Planet("Mercury",84);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);


        temp  = new Planet("Venus",124);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);


        temp  = new Planet("Earth",365);
        temp.addSatllite(new Moon("Moon",27));
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);


        temp  = new Planet("Mars",480);
        temp.addSatllite(new Moon("MarsMoon1",20));
        temp.addSatllite(new Moon("MarsMoon2",48));
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        temp  = new Planet("Jupiter",84);
        temp.addSatllite(new Moon("JupitarMoon1",27));
        temp.addSatllite(new Moon("JupitarMoon2",27));
        temp.addSatllite(new Moon("JupitarMoon3",27));
        temp.addSatllite(new Moon("JupitarMoon4",27));
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);


        temp  = new Planet("Venus",254);
        temp.addSatllite(new Moon("DwarfmoonOfVenuv" , 8));
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        Set<HeavenlyBody> moons = new HashSet<>();
        System.out.println("All Moons");
        for (HeavenlyBody planet : planets){
             moons.addAll(planet.getSatellite());
            }
        for (HeavenlyBody moon : moons){
            System.out.println("\t " +moon.toString());
        }


        
        for(HeavenlyBody planet : planets ) {
            System.out.println(planet);
//            System.out.println(planet.getName() + " : " + planet.getOrbitalPeriod());
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("All Our Solar System ");

        for (HeavenlyBody heavenlyBody  : solarSystem.values()){
            System.out.println(heavenlyBody.getKey().toString() + "\t==>" +heavenlyBody.getOrbitalPeriod());

            for (HeavenlyBody moon : heavenlyBody.getSatellite()){
                System.out.println("\t " +moon.toString());
            }
        }


        HeavenlyBody earth = solarSystem.get(HeavenlyBody.makeKey("Earth", HeavenlyBody.BodyTypes.PLANET));
        System.out.println(earth.getKey().getName() + " has orbitalPeriod of " + earth.getOrbitalPeriod());
//        HeavenlyBody earth1 = new Planet("Earth" , 365);
//        HeavenlyBody earth2 = new Planet("Earth" , 365);
//
//        System.out.println(earth1.equals(earth2));
//        System.out.println(earth2.equals(earth1));
    }
}
