package com.company;

public class Main {
    public static void main(String[] args) {
        Creata affan = new Creata(56,56,4,"Black","TRNS5");
        Creata arfat = affan;
//        affan.getcarinfo();
//        affan.changear(2);
//        affan.setCurrentspeed(56);
//        affan.setCurrentdirection(0);
//        affan.getcarinfo();

        arfat.setColour("white");
        arfat.setModel("TRMSGHF56");
        arfat.getcarinfo();;
        affan.getcarinfo();
    }
}
