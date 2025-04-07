import java.net.*;
import java.util.*;

public class IPInterface {
    public static void main(String[] args) throws SocketException{
        NetworkInterface ni = NetworkInterface.getByName("eth1");
        System.out.println(ni);
        Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
        while(inetAddresses.hasMoreElements()){
            InetAddress ia = inetAddresses.nextElement();
            System.out.println(ia);
        }
    }
}
