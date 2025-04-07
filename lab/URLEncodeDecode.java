import java.io.UnsupportedEncodingException;
import java.net.URLEncoder; 
import java.net.URLDecoder;
import java.net.URL;
import java.net.MalformedURLException;
public class URLEncodeDecode{
	public static void main(String[] args){
		try{
		String u = URLEncoder.encode("50$ Bank's Transfer/s" ,"UTF-8");
		URL ur = new URL("http://www.abcbank.com/payment/Query="+u);
		System.out.println("Encoded: "+ur);
		String a = ur.toString();
		System.out.println("Decoded: "+URLDecoder.decode(a,"UTF-8"));}
		catch(MalformedURLException e){System.out.println("URI syntax error");}
		catch(UnsupportedEncodingException ex){System.out.println("encoding not supported");
		}
	}
}
