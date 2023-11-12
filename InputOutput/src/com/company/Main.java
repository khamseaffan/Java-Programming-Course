package com.company;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


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
