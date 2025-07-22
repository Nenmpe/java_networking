package datagram.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(3001);
            DatagramPacket dp = new DatagramPacket(new byte[100], 100);
            while (true) {
                server.receive(dp);                
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Received: " + str);

                System.out.println("Client Address: " + dp.getAddress());
                System.out.println("Client Port: " + dp.getPort());
                System.out.println("Server Local Address: " + server.getLocalAddress());
                System.out.println("Server Local Port: " + server.getLocalPort());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                byte[] toClient = br.readLine().getBytes();
                InetAddress addr = dp.getAddress();
                int port = dp.getPort();
                DatagramPacket dp1 = new DatagramPacket(toClient, toClient.length, addr, port);
                server.send(dp1);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
