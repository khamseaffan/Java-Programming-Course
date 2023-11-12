package com.company;

public class Main {

    public static void main(String[] args) {
        int playerrank ;
        String player1 = "aman";
        String player2 = "affan";
        String player3 = "shaurya";
        String player4 = "sam bhai";
        int score1 = 1500;
        int score2 = 1000;
        int score3 = 400;
        int score4 = 50;

        playerrank = calculatehighscoreosition(score1);
        diplay(player1,playerrank);

        playerrank= calculatehighscoreosition(score2);
        diplay(player2 ,playerrank);

        playerrank= calculatehighscoreosition(score3);
        diplay(player3 ,playerrank);

        playerrank= calculatehighscoreosition(score4);
        diplay(player4 ,playerrank);

    }

    public static void diplay(String playername, int playerposition){
        System.out.println(playername +" managed to get into position "+playerposition + " on the highscore teble");
    }
    public static int calculatehighscoreosition(int playerscore) {
        if (playerscore >= 1000)
             return  1;
        else if (playerscore > 500 )
             return  2;
        else if (playerscore > 100 )
             return  3;

        return 4;

    }
}
