package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Branch> branches = new ArrayList<>();
    private static boolean buffercontrol = false;

    public boolean addnewcustomer(String branch){
        int branchposition = findbranch(branch);
        if (branchposition == -1){
            System.out.println("Branch record not found");
            return false;
        }
        Branch customerbranch = branches.get(branchposition);
        if (buffercontrol){                         //to control buuffer at time of wrong input
            scanner.nextLine();                     //also during eception
            buffercontrol = false;
        }
        System.out.println("Enter customer name ");
        String cname = scanner.nextLine();
        System.out.println("Enter Customer fist transaction ");
        if(scanner.hasNextDouble()) {
            double firsttransaction = scanner.nextDouble();
            Customer newcustomer = new Customer(cname, firsttransaction);
            boolean result = customerbranch.addnewcustomer(newcustomer);
            buffercontrol = true;
            return result;
        }
        System.out.println("Please enter valid transaction amount");
        buffercontrol = true ;
        return false;

    }

    public boolean addnewbranch(String name ){
        int branchposition = findbranch(name);
        if (branchposition !=-1){
            System.out.println(name + " Branch already exist .");
            return false;
        }
        Branch newbranch = Branch.creatbranch(name);
        branches.add(newbranch);
        return true;
    }

    public void printcustomertransaction(String branchname , String customername){
        int branhposition = findbranch(branchname);
        if (branhposition == -1){
            System.out.println(branchname + " branch is not found in record." );
            return;
        }
        Branch branch = branches.get(branhposition);
        branch.printtransaction(customername);
    }

    public void printcustomerslist(String branchname){
        int branchposition = findbranch(branchname);
        if (branchposition >= 0){
            Branch branch = branches.get(branchposition);
                    branch.printcustomerlist();
             }
        }


    public boolean maketransaction(String branchname, String customername, double transaction){
        int branhposition = findbranch(branchname);
        if (branhposition == -1){
            System.out.println(branchname + " branch is not found in record." );
            return false;
        }
        Branch customerbranch = branches.get(branhposition);
        customerbranch.maketransaction(customername,transaction);
        return true;
    }



    private int findbranch(String branchname) {
        for (int i =0 ; i<branches.size() ; i++){
            Branch searcher = branches.get(i);
            if (searcher.getName().equals(branchname))
                return i;
        }
        return -1;
    }

}
