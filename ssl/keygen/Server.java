package ssl.keygen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Server {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "my_ssl_keys/jnp4e.keys");
        System.setProperty("javax.net.ssl.keyStorePassword", "qwerty");
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SUNX509");
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "qwerty".toCharArray();
            ks.load(new FileInputStream("my_ssl_keys/jnp4e.keys"), password);
            kmf.init(ks, password);
            context.init(kmf.getKeyManagers(), null, null);
            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket server = (SSLServerSocket)factory.createServerSocket(2356);
            while (true) {
                SSLSocket client = (SSLSocket)server.accept();
                InputStream is = client.getInputStream();
                OutputStream os = client.getOutputStream();
                String fromClient = "", toClient = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
                System.out.println(client);
                while (!fromClient.equals("quit")) {
                    fromClient = in.readLine();
                    System.out.println("Client: "+fromClient);
                    toClient = br.readLine();
                    out.write(toClient+"\r\n");
                    out.flush();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
