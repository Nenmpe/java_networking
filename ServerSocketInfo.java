import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSocketInfo {
    public static void main(String[] args) {
        try{
            ServerSocket server1 = new ServerSocket(0);
            System.out.println("Server is running at port:"+server1.getLocalPort());
            InetAddress ia = server1.getInetAddress();
            InetAddress local = ia.getLocalHost();
            System.out.println("IP of server is "+ia.getHostAddress());
            System.out.println("Local IP of server is "+local.getHostAddress());
        }
        catch(IOException ie1){
            System.out.println(ie1.getMessage());
        }
    }
}

