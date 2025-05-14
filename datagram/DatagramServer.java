package datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;


public class DatagramServer {
    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(5555);
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                udpSocket.receive(request);
                String dayTime = new Date().toString();
                byte[] data = dayTime.getBytes();
                InetAddress host = request.getAddress();
                int port = request.getPort();
                DatagramPacket response = new DatagramPacket(data, data.length, host, port);
                udpSocket.send(response);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
