package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock accountLock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountLock = new ReentrantLock();
    }
    //Using Syncronized KeyWord
//    public void deposit(double amount){
//        synchronized (this){
//            this.balance += amount;
//            System.out.println(ThreadColor.ANSI_GREEN+"Amount deposited-> " + amount +"\nTotal Balance-> " + balance);
//        }
//    }
//
//    public void withdraw(double amount){
//        synchronized (this){
//            this.balance -= amount;
//            System.out.println(ThreadColor.ANSI_RED+"Amount Withdraw-> " + amount +"\nTotal Balance-> " + balance);
//        }
//    }

    //Using ReentrantLock
    public void deposit(double amount) {
        boolean status = false;
        try {
            if(accountLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance += amount;
                    System.out.println(ThreadColor.ANSI_GREEN + "Amount deposited-> " + amount + "\nTotal Balance-> " + balance);
                    status = true;
                } finally {
                    accountLock.unlock();
                }
            }
            else {
                System.out.println("Lock Time Out Occur");
            }
        }catch (InterruptedException e){}
        System.out.println("Transaction Status -> " + status );
    }

    public void withdraw(double amount) {
        boolean status = false;
        try{
            if(accountLock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    this.balance -= amount;
                    System.out.println(ThreadColor.ANSI_RED + "Amount Withdraw-> " + amount + "\nTotal Balance-> " + balance);
                    status = true;
                }
                finally {
                    accountLock.unlock();
                }
            }
            else {
                System.out.println("Lock TimeOut Occur");
            }
        }catch (InterruptedException e){}
        System.out.println("Transaction Status -> " + status );
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println(ThreadColor.ANSI_PURPLE + "Account Number -> " + accountNumber);
    }
}
