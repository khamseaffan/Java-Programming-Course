package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private Scanner scan = new Scanner(System.in);
    private  ArrayList<String> contactname =new ArrayList<String>();
    private ArrayList<String> contactnumber = new ArrayList<String>();

    public void storecontact(){
        System.out.println("Enter name");
       String name= scan.nextLine();
       if (contactname.contains(name)){
           System.out.println("Contact exist..");
       }
       else{
           System.out.print("\rEnter number");
           String  number = scan.nextLine();
           setcontact(name , number);
       }
    }

    public void removecontact(){
        System.out.println("enter Contact name ");
        String name = scan.nextLine();
        remove(name);
    }

    public void modifycontact(){
        System.out.printf("\n1.Modify Name & Number \n 2.modify only Namw \n 3.Modify Only Number");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter contact Name that is need to be modified");
        String oldname = scan.nextLine();
        switch (choice){
            case 1:
                System.out.print("Emter New Name ");
                String newname = scan.nextLine();
                System.out.print("Enter New Number ");
                String newnumber = scan.nextLine();
                modifycontact(oldname,newname,newnumber);
                break;
            case 2:
                System.out.print("Emter New Name ");
                 newname = scan.nextLine();
                modifyname(oldname,newname);
                break;
            case 3:
                System.out.print("Enter New Number ");
                newnumber = scan.nextLine();
                modifynumber(oldname,newnumber);
                break;
            default:
                System.out.printf("Wrong choice ... exiting modification Panel");
        }
    }

    public void printallcontact(){
        for (int i =0 ;i<contactname.size(); i++){
            System.out.printf(" Name = "+contactname.get(i) +"\t Phone Number = "+ contactnumber.get(i));
            System.out.printf("\n");
        }
    }



    private void modifycontact(String oldname,String newname , String newnumber){  //when both field are need to be modified
        int position = getposition(oldname);
        if (position>=0){
            contactnumber.set(position,newnumber);
            contactname.set(position,newname);
        }
    }

    private void modifynumber(String name, String newnumber){
        int position =getposition(name);
        if (position>=0)
            contactnumber.set(position, newnumber);
    }

    private void modifyname(String oldname ,String newname){
        int position =getposition(oldname);
        if (position>=0)
             contactname.set(position, newname);
    }

    private void remove(String name){
        int position = getposition(name);
        if (position>=0){
            contactname.remove(position);
            contactnumber.remove(position);
        }
        System.out.println("Contact Removed");

    }

    private int getposition(String name ){
        return contactname.indexOf(name);
    }

    private void setcontact(String name, String number){
        contactname.add(name);
        contactnumber.add(number);
    }


}

