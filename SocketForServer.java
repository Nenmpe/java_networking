import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.io.IOException;

public class SocketForServer {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("resource")
            ServerSocket ss = new ServerSocket(2222);
            while (true) {
                Socket soc = ss.accept();
                OutputStream os = soc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                Date now  = new Date();
                String current = now.toString();   
                bw.write(current);
                bw.flush();
                soc.close();                
            }
        }catch(IOException e){
            System.out.println("I/O error occured");
        }
    }
}
