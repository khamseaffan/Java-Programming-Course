package com.company;

import java.util.Scanner;

public class Main {
 public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        MobilePhone mobile = new MobilePhone();

        boolean quit =false;
        printinstruction();
        while (!quit) {
            System.out.println("Enter your choice");
            int choice = scan.nextInt();
            switch (choice){
                case 0 :
                    printinstruction();
                    break;
                case 1:
                    mobile.storecontact();
                    break;
                case 2:
                    mobile.modifycontact();
                    break;
                case 3:
                    mobile.removecontact();
                    break;
                case 4:
                    mobile.printallcontact();
                    break;
                case 5 :
                    quit =true;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }


    public static void printinstruction(){
        System.out.println("0. Print instruction Panel");
        System.out.println("1. Store contact");
        System.out.println("2. Modify contact");
        System.out.println("3. Remove a contact");
        System.out.println("4. See  all contacts");
        System.out.println("5. Quit");
    }

}
