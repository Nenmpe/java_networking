import java.net.MalformedURLException;
import java.net.URL;

public class URLComponent {
    public static void main(String[] args) {
        try{
				URL ur = new URL("https://admin@www.amazon.com:443/bookfaq/books/index.html?isbn=21506#abc");
				System.out.println("Hostname: "+ur.getHost());
				System.out.println("Protocol: "+ur.getProtocol());
				System.out.println("Port: "+ur.getPort());
				System.out.println("Path: "+ur.getPath());
				System.out.println("Default port: "+ ur.getDefaultPort());
				System.out.println("REF: "+ur.getRef());
				System.out.println("File: "+ur.getFile());
				System.out.println("UserInfo: "+ur.getUserInfo());
				System.out.println("Authority: "+ur.getAuthority());
				System.out.println("Query: "+ur.getQuery());
			}
			catch(MalformedURLException me){
				System.out.println("unknown syntax/protocol");
			}

    }
}
