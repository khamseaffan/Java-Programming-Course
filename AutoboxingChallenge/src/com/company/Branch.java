package com.company;

import java.util.ArrayList;

public class Branch {
    private String name ;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public boolean addnewcustomer(Customer customer){
        String customername = customer.getName();
        int customerposition = findcustomer(customername);
        if (customerposition != -1){
            System.out.println("Custormer already exist..");
            return false;
        }
        customers.add(customer);
        return true;
    }

    public boolean maketransaction(String customername , double transaction){
        int customerposition = findcustomer(customername);
        if (customerposition == -1){
            System.out.println("Custormer Does not exist..");
            return false;
        }
        Customer customer = customers.get(customerposition);
        customer.addtransaction(transaction);
        return true;
    }

    public void printcustomerlist(){
        System.out.println("\tBranch " + getName());
        System.out.println(" Customer list");
        for (int i = 0 ;i<customers.size() ; i++){
            Customer customer = customers.get(i);
            System.out.println((i+1) + customer.getName());
            customer.getTransactions();
        }
    }

    public void printtransaction(String customername){
        int customerposition = findcustomer(customername);
        if (customerposition >= 0){
        Customer customer = customers.get(customerposition);
        customer.getTransactions();
        return;
        }
        System.out.println(customername + " is not on " + getName() + " record.");
    }

    public int customerlistsize(){
        return customers.size();
    }
    private int findcustomer(Customer customer) {
        return customers.indexOf(customer);
    }

    private int findcustomer(String name){
        for (int i =0 ; i<customers.size() ; i++){
            Customer searcher = customers.get(i);
            if (searcher.getName().equals(name))
                return i;
        }
        return -1;
    }

    public static Branch creatbranch(String name){
        return new Branch(name);
    }

}
