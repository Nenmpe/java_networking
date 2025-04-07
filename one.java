
import java.net.InetAddress;
import java.net.UnknownHostException;
public class one{
	public static void main(String[]args){
		try{
			// InetAddress[] ips = InetAddress.getAllByName("www.apple.com"); // For getting inet address of any host
            InetAddress ip = InetAddress.getLocalHost(); // For local device address
			// String ipAddr = ip.getHostAddress();
			// System.out.println(ipAddr);
			// for(InetAddress ip:ips){
			// 	System.out.println(ip.getHostAddress());
			// }
			System.out.println("The host name is: "+ip.getHostName());
			System.out.println("The host ip is: "+ip.getHostAddress());			
			// System.out.println(ip.getCanonicalHostName());
			// byte[] bip = ip.getAddress();
			// for(byte i:bip){
			// 	System.out.println(i);	
			// }
			// if(bip.length == 4){
			// 	System.out.println("The host has IPv4 address");
			// }
			// else {
			// 	System.out.println("The host has invalid address");
			// }
			
		}
		catch(UnknownHostException uhe) {
			System.out.println("UnknownHostException occured");
			
		}
	}
}
