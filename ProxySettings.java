// import java.net.Proxy;
// import java.net.ProxySelector;
// import java.net.InetSocketAddress;
// import java.net.SocketException;
// import java.net.SocketAddress;
// import java.net.URI;
// import java.net.URL;
// import java.net.URISyntaxException;
// import java.io.IOException;
// import java.util.*;

// public class ProxySettings extends ProxySelector{
//     public List<Proxy> select(URI uri){
//         List<Proxy> pl = new ArrayList<Proxy>();
//         if(!"http".equalsIgnoreCase(uri.getScheme())){
//             pl.add(Proxy.NO_PROXY);
//         }
//         else{
//             SocketAddress sa = new InetSocketAddress("proxy.mycompany.com", 8000);
//             Proxy p = new Proxy(Proxy.Type.HTTP, sa);
//             pl.add(p);
//         }
//         return pl;
        
//     }

//     public void connectFailed(URI uri, SocketAddress sa, IOException ioe){
//         System.out.println("Connection failed for URI = "+uri);
//     }

//     public static void main(String[] args) {
//         try{
//             ProxySelector ps = new ProxySettings();
//             ProxySelector.setDefault(ps);
//             System.out.println("Default ProxySelector = "+ProxySelector.getDefault());
//             URI uri = new URI("urn:");
//             List<Proxy> p1 = ps.select(uri);
//         }
//         catch(URISyntaxException use){
//             System.out.println("URI syntax error. MSG = "+use);
//         }
//         // catch(IOException ioe){
//         //     System.out.println("I/O error. MSG = "+ioe);
//         // }
//     }
// }
