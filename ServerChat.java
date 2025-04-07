import java.net.*;
import java.io.*;

public class ServerChat {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(13);
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
            System.out.println("I/O error occured");
        }
    }
}
