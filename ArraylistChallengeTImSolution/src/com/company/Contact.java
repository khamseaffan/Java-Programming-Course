package com.company;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public static Contact createcontact(String name, String number) {
        return new Contact(name,number);
    }
    //static because then to use this method we does no
    //require to creat any object of this class
}