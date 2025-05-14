package datagram.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            while (true) {
                BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
                String str = br.readLine();
                byte[] buf = str.getBytes();
                InetAddress addr = InetAddress.getByName("localhost");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, 3001);
                DatagramSocket socket = new DatagramSocket();
                socket.send(packet);
                DatagramPacket response = new DatagramPacket(new byte[50], 50);
                socket.receive(response);
                String responseString = new String(response.getData(), 0, response.getLength());
                System.out.println("Received response: " + responseString);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
