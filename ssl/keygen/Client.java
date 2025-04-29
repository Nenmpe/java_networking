package ssl.keygen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Client {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "my_ssl_keys/myTrustStore.jts");
        System.setProperty("javax.net.ssl.trustStorePassword", "qwerty");
        try {
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket client = (SSLSocket)factory.createSocket("localhost", 2356);
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            String fromServer = "", toServer = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
            System.out.println(client.getSession());
            System.out.println(client);

            while (!fromServer.equals("quit")) {
                toServer = br.readLine();
                out.write(toServer+"\r\n");
                out.flush();
                fromServer = in.readLine();
                System.out.println("Server: "+fromServer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
