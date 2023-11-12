package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        BankAccount account = new BankAccount(1000,"ak001");
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){}
                account.withdraw(50);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run(){
                account.deposit(203.75);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){}
                account.withdraw(100);
        }
        }).start();
    }



}
