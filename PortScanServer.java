import java.io.IOException;
import java.net.ServerSocket;

public class PortScanServer {
    public static void main(String[] args) {
        for(int i = 21;i <= 25; i++){
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                System.out.println("Server created at port: " + i);
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage() + " Port: " + i);
            }
        }
    }
}