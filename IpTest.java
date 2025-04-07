
import java.net.*;

public class IpTest {
    public static void main(String[] args) {
        try{
            InetAddress iad = InetAddress.getByName(args[0]);
            if(iad.isAnyLocalAddress()){System.out.println("IP is Local Address");}
            else if(iad.isLoopbackAddress()){System.out.println("IP is Loopback Address");}
            else if(iad.isLinkLocalAddress()){System.out.println("IP is Link Local Address");}
            else if(iad.isSiteLocalAddress()){System.out.println("IP is Site Local Address");}
            else if(iad.isMulticastAddress()){
                if(iad.isMCGlobal()){System.out.println("IP is Multicast Global Address");}
                if(iad.isMCOrgLocal()){System.out.println("IP is Multicast organizational Address");}
                if(iad.isMCLinkLocal()){System.out.println("IP is Multicast Link Local Address");}
                if(iad.isMCSiteLocal()){System.out.println("IP is Multicast Site Local Address");}
                if(iad.isMCNodeLocal()){System.out.println("IP is Multicast Node Local Address");}
            }
            else{
                System.out.println("IP is Unicast Address");
            }

        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
    }
}
