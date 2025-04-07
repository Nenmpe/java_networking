import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MacAddress {
    public static void main(String[] args) {
        try{
            InetAddress is = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(is);
            byte[] mac = ni.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for(byte m: mac){
                sb.append(String.format("%02X", m));
            }
            System.out.println(sb);
        }
        catch(SocketException se){
            System.out.println(se);
        }
        catch(UnknownHostException ue){
            System.out.println(ue);
        }
        
    }
}
