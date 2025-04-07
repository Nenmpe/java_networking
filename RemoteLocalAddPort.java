import java.io.*;
import java.net.*;

public class RemoteLocalAddPort {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("time.nist.gov", 13);
            InetAddress iadd = soc.getInetAddress();
            String host = iadd.getHostAddress();
            InetAddress local = InetAddress.getLocalHost();
            String locad = local.getHostAddress();
            System.out.println("Remote Address: "+host);
            System.out.println("Remote Port: "+soc.getPort());
            System.out.println("Local Address: "+locad);
            System.out.println("Local Port: "+soc.getLocalPort());  
            soc.close();    
        }catch(UnknownHostException e){
            System.out.println("Unable to resolve the host");
        }catch(IOException ex){
            System.out.println("I/O error occured");
        }
    }
}
