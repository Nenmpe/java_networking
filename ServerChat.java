import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(3005);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader inbr = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            String fromClient = "";
            String toClient = "";
            BufferedReader outbr = new BufferedReader(new InputStreamReader(System.in));

            while(!fromClient.equals("stop")){
                fromClient = inbr.readLine();
                System.out.println("Client: " + fromClient);
                toClient = outbr.readLine();
                bw.write(toClient + "\n");
                bw.flush();
            }
            server.close();
        }catch(IOException e){
            System.out.println("I/O error occured: "+e.getMessage());
        }
    }
}
