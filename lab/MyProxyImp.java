import java.net.*;
import java.io.*;
import java.util.*;
public class MyProxyImp {
	public static void main(String[] args) throws IOException,URISyntaxException{
		MyProxySelector MPS = new MyProxySelector();
		ProxySelector.setDefault(MPS);
		System.out.println("Default proxy: "+MPS);
		URI ur1 = new URI("urn://www.google.com/home/index.html?q=question#FAQ");
		List<Proxy> p1 = MPS.select(ur1);
		System.out.println("Proxy Server is: "+p1.get(0));	
	}
}
