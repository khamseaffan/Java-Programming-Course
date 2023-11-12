package com.company;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try{
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String message;

            do{
                System.out.println("Enter String To Send To Server");
                message =  scanner.nextLine();
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address,5000);
                socket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
                System.out.println("client: Echo String Receive is "+ new String(buffer2, 0, packet.getLength()));


            }while(!message.equalsIgnoreCase("exit"));
        }catch (SocketException e){
            System.out.println("Socekt Exception Clent: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IoExceptio Exception Client: " + e.getMessage());
        }
    }
}
