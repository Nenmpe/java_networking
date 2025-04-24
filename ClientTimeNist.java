import java.io.IOException;
import java.net.Socket;

public class ClientTimeNist {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov", 13);
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Local Address: " + socket.getLocalAddress());
            socket.close();
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
