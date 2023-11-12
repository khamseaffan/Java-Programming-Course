package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobile = new MobilePhone("5656522");

    public static void main(String[] args) {
           startcontactpanel();
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
                        mobile.printcontact();
                        break;
                    case 2:
                        addNewContact();
                        break;
                    case 3:
                        updatecontact();
                        break;
                    case 4:
                        removecontact();
                        break;
                    case 5:
                        Querycontact();
                        break;
                    case 6 :
                        quit =true;
                        System.out.println("Closing the contact panel....");
                        break;
                    default:
                        System.out.println("Wrong choice");
                }
            }
        }

        private static void startcontactpanel(){
            System.out.println("Contact panel opened...");
        }

    private static void addNewContact(){

        System.out.println("Enter New Contact Name");
        String cname = scanner.nextLine();
        System.out.println("Enter New Phone number");
        String phone = scanner.nextLine();

        Contact newcontact = Contact.createcontact(cname,phone);
        if(mobile.addNewContact(newcontact))
            System.out.println(" New Contact Added");
        else
            System.out.println("cannot add" + cname + " on File");
        //using creatcontact without creating object of this class(Contact)
    }

    private static void updatecontact(){
        System.out.println("Enter Existing contact name");
        String name = scanner.nextLine();
        Contact existingcontactrechord = mobile.querycontact(name);
        if (existingcontactrechord == null){
            System.out.println("Contact not found");
        }
        else {

        System.out.println("Enter new contact name");
        String cname = scanner.nextLine();
        System.out.println("\nEnter new contact number");
        String number = scanner.nextLine();
        Contact newcontact = new Contact(cname,number);
        if (mobile.updatecontact(existingcontactrechord, newcontact)){
            System.out.println(existingcontactrechord.getName() + " has been updated to " + newcontact.getName());
        }
        else {
            System.out.println("Contact update failed");
        }
        }
    }


    private static void removecontact(){
        System.out.println("Enter Existing contact name");
        String name = scanner.nextLine();
        Contact existingcontactrechord = mobile.querycontact(name);
        if (existingcontactrechord == null) {
            System.out.println("Contact not found");
            return;
        }
                mobile.removecontact(existingcontactrechord);

        }

    public static void Querycontact(){
        System.out.println("Enter Existing contact name");
        String name = scanner.nextLine();
        Contact contactrechord = mobile.querycontact(name);
        if (contactrechord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name = " + contactrechord.getName() + "Phone number-> " + contactrechord.getNumber());
    }

    public static void printinstruction(){
        System.out.println("0. Print instruction Panel");
        System.out.println("1. Print contact");
        System.out.println("2. Store new contact");
        System.out.println("3. Update contact");
        System.out.println("4. Remove contacts" +
                            " \n5. Query for existing contact" +
                            "\n6. Quit");
    }





}
