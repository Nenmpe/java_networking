package ssl;

import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class SSLClient {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket)factory.createSocket("www.usps.com", 443);
            System.out.println("Successfully connected to: "+socket);
        } catch (IOException e) {
            System.out.println("I/O Error: "+e.getMessage());
        }
    }
}
