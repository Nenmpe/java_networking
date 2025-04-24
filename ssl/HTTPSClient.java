package ssl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClient {

    public static void main(String[] args) {
        try {
            String host = "www.google.com";
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket)factory.createSocket(host, 443);

            String[] supported = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supported);
            
            OutputStream os = socket.getOutputStream();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
            out.write("GET https://www.google.com/ HTTP/1.1\r\n");
            out.write("Host:www.google.com\r\n");
            out.write("\r\n");out.flush();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: "+e.getMessage());
        }
    }
}
