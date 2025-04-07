import java.net.Socket;
import java.io.InputStream;
import java.io.IOException;

public class SocketForClients {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("192.168.1.184", 3008);
            InputStream is = socket.getInputStream();
            int a;
            while((a = is.read()) != -1){
                System.out.print((char) a);
            }
            socket.close();
        }catch(IOException e){
            System.out.println("I/O error occured");
        }
    }
}
