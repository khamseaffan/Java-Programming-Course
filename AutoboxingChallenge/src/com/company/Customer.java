package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions ;

    public Customer(String name, double transactions) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addtransaction(transactions);
    }


    public String getName() {
        return name;
    }

    public void getTransactions(){
        for (int i = 0 ;i<transactions.size() ; i++){
            Double transaction = transactions.get(i);
            System.out.println( "\t" +(i+1) + "." + transaction.doubleValue());
        }
    }

    public void addtransaction(double transactionamount){
        transactions.add(transactionamount);
    }

}
