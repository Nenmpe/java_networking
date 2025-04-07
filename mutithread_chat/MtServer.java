package mutithread_chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MtServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3005);

            while(true){
                Socket client = server.accept();
                Mtprog threadedServer = new Mtprog(client);
                new Thread(threadedServer).start();
            }
        } catch (IOException ie) {
            System.out.println("I/O Exception:"+ ie.getMessage());
        }
    }
}
