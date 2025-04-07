package mutithread_chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MtClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("192.168.1.179", 3005);
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
