package com.company;

public class bankaccount {
    private int accountnumber ;
    private double balance;
    private String customername;
    private String email;
    private String phonenumber;

    public void bankaccount(int accountnumber,double balance, String customername, String email, String phonenumber){
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.customername = customername;
        this.email = email;
        this.phonenumber = phonenumber;
    }
    public  void deposite(double deposite){
        this.balance += deposite;
        System.out.println(deposite + "has bee deposited Now Total Balance =" + this.balance);
    }
    public void withdraw(double amount){
        if (this.balance - amount >0){
            this.balance-=amount;
            System.out.println(amount + "has been Withdrawn ,Now Balance = " + this.balance);
        }
        else
            System.out.println("Insufficient amount ,Withdraw not possible");
    }
    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getEmacil() {
        return email;
    }

    public void setEmacil(String emacil) {
        this.email = emacil;
    }

    public String  getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
