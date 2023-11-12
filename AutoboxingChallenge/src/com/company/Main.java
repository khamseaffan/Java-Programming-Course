package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank idbi = new Bank();

    public static void main(String[] args) {

        startapplication();
        boolean quit =false;
        printinstruction();
        while (!quit) {
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine();                //Important to prevent buffer
            switch (choice){
                case 0 :
                    printinstruction();
                    break;
                case 1:
                    addnewbranch();
                    break;
                case 2:
                    addnewcustomer();
                    break;
                case 3:
                    transactionofcustomer();
                    break;
                case 4:
                    printcustomerlist();
                    break;
                case 5:
                    maketransaction();
                    break;
                case 6 :
                    quit =true;
                    System.out.println("Closing the Application....");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void startapplication(){
        System.out.println("Application has been started..");
    }

        public static void printinstruction(){
        System.out.println("0. Print instruction Panel");
        System.out.println("1. Add New Branch ");
        System.out.println("2. Add new Customer");
        System.out.println("3. Print Transaction of a customer ");
        System.out.println("4. Print customer list of a Branch \n" +
                            "5. Make trancation of customer \n" +
                            "6. to Quit application");
    }

    public static void addnewbranch(){
        System.out.println("Enter Name of new branch");
        String name = scanner.nextLine();
        if(idbi.addnewbranch(name)){
            System.out.println(name + " Branch has been added.");
        }
    }

    public static void addnewcustomer(){
        System.out.println("Enter Branch name for account opening ");
        String branchname = scanner.nextLine();
        if(idbi.addnewcustomer(branchname)) {
            System.out.println("Customer record has been added ");
        }
        else {
            System.out.println("Customer record addition failed");
        }
    }


    private  static void transactionofcustomer(){
        System.out.println("Enter Branch of customer ");
        String branchname = scanner.nextLine();
        System.out.println("Enter Customer name ");
        String cname = scanner.nextLine();
        idbi.printcustomertransaction(branchname, cname);
    }

    private static void printcustomerlist(){
        System.out.println("Enter Branch of bank ");
        String branchname = scanner.nextLine();
        idbi.printcustomerslist(branchname);
    }

    private static void maketransaction(){
        System.out.println("Enter Customer Branch name  ");
        String branchname = scanner.nextLine();
        System.out.println("Enter customer name ");
        String cname = scanner.nextLine();
        System.out.println("Enter transaction Amount");
        double transaction = scanner.nextDouble();
        idbi.maketransaction(branchname,cname,transaction);
    }










}
