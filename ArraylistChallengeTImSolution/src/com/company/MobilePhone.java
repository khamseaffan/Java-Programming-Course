package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String mynumber;
    private ArrayList<Contact> mycontact;

    public MobilePhone(String mynumber) {
        this.mynumber = mynumber;
        this.mycontact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if(getposition(contact.getName()) >=0) {
            System.out.println("Contact is already on file");
            return false;
        }

        mycontact.add(contact);
        return true;

    }

    public boolean updatecontact(Contact oldcontact, Contact newcontact){
        int pos = getposition(oldcontact);
        if (pos>=0){
            this.mycontact.set(pos , newcontact);
            System.out.println(oldcontact.getName() + "has been replaced by " + newcontact.getName());
            return true;
        }
        System.out.println(oldcontact.getName() +" does not found !!");
        return false;
    }


    public boolean removecontact(Contact contact){
        int pos = getposition(contact);
        if (pos>=0){
            this.mycontact.remove(pos);
            System.out.println("Contact removed..");
            return true;
        }
            System.out.println("Contact not found...");
            return false;
    }

    public void printcontact(){                        //To prinnt cotact
        System.out.println("\tContact List");
        for (int i =0 ;i<this.mycontact.size() ;i++){
            System.out.println((i+1) + "." + this.mycontact.get(i).getName() +
                                    "-->" +this.mycontact.get(i).getNumber());
        }
    }


    public String querycontact(Contact contact) {
        if (getposition(contact)>=0){
            return contact.getName();
        }
        return null;
        //To check whether a contact exist or not
    }

    public Contact querycontact(String name){
        int position = getposition(name);
        if (position>=0){
            return this.mycontact.get(position);
        }
        return null;
    }


    private int getposition(Contact contact){
        return mycontact.indexOf(contact);
    }

    private int getposition(String contactname){
        for (int i = 0;i<mycontact.size() ; i++){
            Contact contact = mycontact.get(i);
            if (contact.getName().equals(contactname))
                return i;
        }
        return -1;
    }




}
