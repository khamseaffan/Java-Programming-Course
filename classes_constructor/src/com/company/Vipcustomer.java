package com.company;

public class Vipcustomer {
    private String name;
    private double creditlimit;
    private String email;

    public Vipcustomer(String name, double creditlimit) {
      this(name,creditlimit,"unkown");
    }

    public Vipcustomer(String name, double creditlimit, String email) {
        this.name = name;
        this.creditlimit = creditlimit;
        this.email = email;
    }

    public Vipcustomer() {
        this("affan", 0.00, "unkown");
    }

    public String getName() {
        return name;
    }

    public double getCreditlimit() {
        return creditlimit;
    }

    public String getEmail() {
        return email;
    }
}
