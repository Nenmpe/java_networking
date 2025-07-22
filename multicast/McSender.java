package multicast;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;

public class McSender {
    public static void main(String[] args) {
        try (MulticastSocket moc = new MulticastSocket()) {
            byte[] msgb = "Hello from Mikshan".getBytes();
            InetAddress ia = InetAddress.getByName("224.0.0.5");
            DatagramPacket dp = new DatagramPacket(msgb, msgb.length, ia, 2356);
            moc.send(dp);
            System.out.println("Message Sent!");
        } catch (IOException e) {
            System.out.println("ERROR:: "+e.getMessage());
        }
    }
}
