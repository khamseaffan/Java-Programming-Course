package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter No. of array element You need");
        int number = scan.nextInt();
        int[] myarray = getintegers(number);
        System.out.println("Sorting Started..");
        int[] sortedarray = Arrays.copyOf(myarray,myarray.length);
        sortarray(sortedarray);
        System.out.println("Original Array = > ");
        printarray(myarray);
        System.out.println("\n Sorted Array => ");
        printarray(sortedarray);

    }

    public static int[] getintegers(int num) {
        System.out.println("Enter array elements \r");
        int[] values = new int[num];
        for (int i =0 ; i<values.length ; i++){
            values[i] = scan.nextInt();
        }
        return values;
    }

    public static void printarray(int[] array){
        for (int i =0 ; i<array.length ; i++){
            System.out.print(array[i] +"  ");
        }
    }

    public static void sortarray(int[] array){
        int i,j;
        for (i=0; i<array.length ; i++){
            for (j=0; j<(array.length-1) ;j++){
                if (array[j]<array[j+1]){
                    int temp =array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

//            System.out.println("After iteration No. "+ (i+1) + " array is\n ");
//            printarray(array);

        }
    }
}