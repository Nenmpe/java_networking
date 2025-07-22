package multicast;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class McReceiver{
    public static void main(String[] args) {
        try (MulticastSocket soc = new MulticastSocket(2356)) {
            byte[] data = new byte[100];
            InetAddress gAddress = InetAddress.getByName("224.0.0.5");
            SocketAddress sa = new InetSocketAddress(gAddress, 2356);
            soc.joinGroup(sa, null);
            DatagramPacket receiver = new DatagramPacket(data, data.length);
            soc.receive(receiver);
            String msg = new String(receiver.getData(), 0, receiver.getLength());
            System.out.println("Received Message: "+msg);
        } catch (IOException e) {
            System.out.println("ERROR:: "+e.getMessage());
        }
    }
}