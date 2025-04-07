import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.net.InetAddress;
// import java.net.UnknownHostException;
// import java.io.IOException;

public class Networkinter2 {
    public static void main(String[] args) {
        try{
            Enumeration<NetworkInterface> eni = NetworkInterface.getNetworkInterfaces();
            while(eni.hasMoreElements()){
                NetworkInterface ni = eni.nextElement();
                System.out.println(ni);
                Enumeration<InetAddress> en = ni.getInetAddresses();
                while(en.hasMoreElements()){
                    System.out.println(en.nextElement());
                }
            }
        }
        catch(SocketException se){
            System.out.println(se);
        }
    }
}
