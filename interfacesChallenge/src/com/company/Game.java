package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game implements ISaveable {

    private List<Player> players;

    public Game() {
        this.players =  new ArrayList<>();
    }


    public void printPlayers(){
        for (Player playerinfo : players){
            System.out.println(playerinfo.toString());
        }
    }

    @Override
    public void write(List<Player> tobesavevalue) {
        System.out.println("Values To be Saved are \n");
        for (Player playerinfo : tobesavevalue){
            System.out.println(playerinfo.toString());
        }
        System.out.println("Value Saved...");
    }

    @Override
    public void read(ArrayList<Player> NewPlayers) {
        players.addAll(NewPlayers);

    }
}
