package com.company;

public class Main {

    public static void main(String[] args) {
    /* bankaccount affan = new bankaccount();
     bankaccount arfat = new bankaccount();
     affan.bankaccount(2166,2156422,"affan" , "adaghj@juhd.com", "56558542");
        System.out.println(affan.getBalance());
        System.out.println(arfat.getAccountnumber()  + "\n" + arfat.getBalance() );
    */

    Vipcustomer affan = new Vipcustomer();
    Vipcustomer arfat = new Vipcustomer("arfat",152245.54);
        System.out.println("Name "+ affan.getName());
        System.out.println("arfat email " + arfat.getEmail());
    }


}
