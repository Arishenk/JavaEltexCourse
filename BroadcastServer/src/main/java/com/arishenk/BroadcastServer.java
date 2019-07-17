package com.arishenk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4445);
        DatagramPacket packet = new DatagramPacket (new byte[1024], 1024);
        while (true) {
            try {
                socket.receive (packet);
                System.out.println("Received from: " + packet.getAddress () + ":" +
                        packet.getPort ());
            } catch (IOException error) {
                error.getMessage();
            }
        }
    }
}
