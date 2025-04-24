import java.io.IOException;
import java.net.Socket;

public class LocalPortClient {
    public static void main(String[] args) {
        for(int p = 10; p<=25;p++){
            try {
                Socket socket = new Socket("localhost", p);
                System.out.println("Connected to port: " + p);
                socket.close();
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }
            
        }
    }
}
