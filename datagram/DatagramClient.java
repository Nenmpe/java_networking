package datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;

public class DatagramClient {
    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(0);
            udpSocket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket toSend = new DatagramPacket(new byte[100], 10, host, 5555);
            byte[] data = new byte[100];
            DatagramPacket toReceive = new DatagramPacket(data, 100);
            udpSocket.send(toSend);
            udpSocket.receive(toReceive);
            String output = new String(toReceive.getData(), 0, toReceive.getLength());
            System.out.println("Response from server: \n" + output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
