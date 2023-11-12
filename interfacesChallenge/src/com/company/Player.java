package com.company;

public class Player {

    private String PlayerName;
    private int PlayerRating;


    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public int getPlayerRating() {
        return PlayerRating;
    }

    public void setPlayerRating(int playerRating) {
        PlayerRating = playerRating;
    }

    public Player(String playerName, int playerRating) {
        PlayerName = playerName;
        PlayerRating = playerRating;
    }

    public String toString() {
        return "Player{" +
                "PlayerName='" + PlayerName + '\'' +
                ", PlayerRating=" + PlayerRating +
                '}';
    }
}
