package com.example.company;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer , Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> tempExits = new HashMap<String ,Integer>();

        locations.put(0,new Location(0,"In Front of Computer",tempExits));

        tempExits = new HashMap<String ,Integer>();
        tempExits.put("N",3);
        tempExits.put("S",5);
        tempExits.put("W",2);
        locations.put(1,new Location(1,"House",tempExits));

        tempExits = new HashMap<String ,Integer>();
        tempExits.put("N",3);
        tempExits.put("E",1);
        locations.put(2,new Location(2,"Mall",tempExits));

        tempExits = new HashMap<String ,Integer>();
        tempExits.put("E",4);
        locations.put(3,new Location(3,"Hill" , tempExits));

        tempExits = new HashMap<String ,Integer>();
        tempExits.put("W",1);
        tempExits.put("N",3);
        locations.put(4,new Location(4,"track", tempExits));

        tempExits = new HashMap<String ,Integer>();
        tempExits.put("N",1);
        tempExits.put("W",2);
        locations.put(5,new Location(5,"Hotel",tempExits));

        Map<String , String > vocabulary = new HashMap<>();
        vocabulary.put("NORTH" , "N");
        vocabulary.put("SOUTH" , "S");
        vocabulary.put("WEST" , "W");
        vocabulary.put("EAST" , "E");
        vocabulary.put("QUIT" , "Q");

        int loc = 1;
        while(true){

            System.out.println("Your in " + locations.get(loc).getDescription());
            System.out.print("You can go in: ");
            Map<String ,Integer> exits  =locations.get(loc).getExits();
            for(String direction : exits.keySet()){
                System.out.print(direction + " ");
            }
            String direction = scanner.nextLine().toUpperCase();

            if (direction.length()>1) {
                String[] words = direction.split(" ");
                for (String word : words){
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }

            }

            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            }
            else
                System.out.println("You Cannot GO in that Direction");
            if(loc==0){
                System.out.println("You Are " + locations.get(loc).getDescription());
                break;
            }
        }
    }

    private static String getDirection (String movementInput){
        String[] splittedInput = movementInput.split(" ");
        for (String input : splittedInput){
            switch (input.toUpperCase()) {
                case "NORTH":
                case "N":
                    return "N";
                case "SOUTH":
                case "S":
                    return "S";
                case "EAST":
                case "E":
                    return "E";
                case "WEST":
                case "W":
                    return "W";
                case "QUIT":
                case "Q":
                    return "Q";
            }
        }
        return "t";
    }
}
