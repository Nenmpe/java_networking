import java.net.*;
import java.io.*;

public class ReachSite {
    public static void main(String[] args) {
        try{
            int timeOut = 60;
            InetAddress ip = InetAddress.getByName("fohss.tu.edu.np");
            if(ip.isReachable(timeOut)){
                System.out.println(ip+"The host is reachable");
            }
            else{
                System.out.println("The host is not reachable");
            }
        }catch(UnknownHostException uhe){
            System.out.println("UnknownHostException occured");
        }catch(IOException ie){
            System.out.println("I/O error occured");
        }
    }
}
