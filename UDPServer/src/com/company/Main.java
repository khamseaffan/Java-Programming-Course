package com.company;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try{
            DatagramSocket socket = new DatagramSocket(5000);

            while(true){
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Server: String Receive is "+ new String(buffer, 0, packet.getLength()));

                String echoMessage = new String(buffer , 0, packet.getLength());
                echoMessage += " Echoed";
                byte[] echoBuffer = echoMessage.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(echoBuffer, echoBuffer.length, address, port);
                socket.send(packet);
            }

        }catch (SocketException e){
            System.out.println("Socekt Exception: " + e.getMessage());
        }catch (IOException e){
            System.out.println("Io Exception: " + e.getMessage());
        }
    }
}
