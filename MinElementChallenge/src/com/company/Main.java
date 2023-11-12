package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Number of element you need to enter");
        int count = scan.nextInt();
        int[] myarray =readinteger(count);
        System.out.println("Original array..");
        printarray(myarray);
//        System.out.println("Minimum of all element is "+ findmin(myarray));
        reversearray(myarray);
        System.out.println("\rreverse of array..\r");
        printarray(myarray);

    }

    public static void printarray(int[] array){
        for (int i=0 ;i<array.length ; i++)
            System.out.print(array[i] + " ");
    }

    public static int[] readinteger(int count){
        System.out.println("Start Entering Integers");
        int[] values = new int[count];
        for (int i=0; i<values.length ; i++){
            values[i] = scan.nextInt();
        }
        return values;
    }
    public static int findmin(int[] array){
        System.out.println("Finding minimum...");
        int min= array[0];
        for (int i=1 ; i<array.length ; i++){
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static void reversearray(int[] array){
        System.out.println("Reversing array....");
        int i,j;
        for ( i =0, j =(array.length-1) ; i<j ; i++,j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

