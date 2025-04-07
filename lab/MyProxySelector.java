import java.io.*; 
import java.net.*;
import java.util.*;
public class MyProxySelector extends ProxySelector{
	public List<Proxy> select(URI uri){
		List<Proxy> proxiess= new ArrayList<Proxy>();
		if(!"http".equalsIgnoreCase(uri.getScheme())){
			proxiess.add(Proxy.NO_PROXY);}
		else{
			SocketAddress sa = new InetSocketAddress("example.proxy.com" , 8000);
			Proxy pr = new Proxy(Proxy.Type.HTTP, sa);
			proxiess.add(pr);	}
		return proxiess;}
	public void connectFailed(URI uri, SocketAddress address, IOException ex){
		System.out.println("unable to connect to proxy");}
}
