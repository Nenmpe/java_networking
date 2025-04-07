import java.net.InetAddress;
import java.net.UnknownHostException;

public class two{
	public static void main(String[]args) throws UnknownHostException{
		InetAddress iad = InetAddress.getLocalHost();
		byte[] addr = iad.getAddress();
		if(addr.length==4){
		System.out.println("The address is IPv4 address");
		}
		else if(addr.length==16){
		System.out.println("The address is IPv6 address");
		}
		else{
		System.out.println("The address is invalid.");
		}
	}
}

