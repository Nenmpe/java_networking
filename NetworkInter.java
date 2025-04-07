
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkInter {
    public static void main(String[] args) {
        try{
            InetAddress ia = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByName("wireless_32768");
            NetworkInterface nif = NetworkInterface.getByInetAddress(ia);
            System.out.println(ni);
            System.out.println(nif);
        }
        catch(SocketException se){
            System.out.println(se);
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
    }
}
