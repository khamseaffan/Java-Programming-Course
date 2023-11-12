package com.company;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game gamePlayer = new Game();
        System.out.println("Application Started..");
        System.out.println("Reading Values..");
        ArrayList<Player> NewPlayersInfo = readValues();
        gamePlayer.read(NewPlayersInfo);
        gamePlayer.write(NewPlayersInfo);

        System.out.println("Second Entry=======================");
        NewPlayersInfo = readValues();
        gamePlayer.read(NewPlayersInfo);
        gamePlayer.write(NewPlayersInfo);

        ISaveable Affan = new Game();
        ((Game) Affan).printPlayers();

    }


    public static ArrayList<Player> readValues() {
        ArrayList<Player> values = new ArrayList<Player>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a Player name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Player Rating");
                    int rating = scanner.nextInt();
                    Player newplayer = new Player(name , rating);
                    values.add(index, newplayer );
                    index++;
                    break;
            }
        }
        return values;
    }
}
