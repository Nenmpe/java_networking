import java.net.*;
import java.io.*;

public class ClientChat {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 13);
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            BufferedReader inbr = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            String fromServer = "";
            String toServer = "";
            BufferedReader outbr = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                toServer = outbr.readLine();
                bw.write(toServer + "\n");
                bw.flush();
                fromServer = inbr.readLine();
                System.out.println("Server: " + fromServer);
                if (toServer.equals("stop")) {
                    client.close();
                    break;
                }                
            }
        } catch (IOException e) {
            System.out.println("I/O error occured");
        }
    }
}
