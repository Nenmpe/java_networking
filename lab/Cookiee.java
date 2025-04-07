import java.net.CookieManager; import java.net.CookieHandler; import java.net.URL;
import java.net.CookieStore;import java.net.URLConnection; import java.util.List;
import java.net.HttpCookie;import java.net.MalformedURLException;import java.io.IOException;
public class Cookiee{
	public static void main(String[] args){
		try{CookieManager cm = new CookieManager();
			CookieHandler.setDefault(cm);
			URL ur = new URL("https://bbc.com");
			URLConnection uc = ur.openConnection();
			uc.getContent();
			CookieStore cs = cm.getCookieStore();
			List<HttpCookie> cookie = cs.getCookies();
            if(cookie.isEmpty()){
                System.out.println("No Cookied received");
            }
            else{
                for(HttpCookie hc: cookie){
                    System.out.println(hc);System.out.println("domain: "+hc.getDomain());
                    System.out.println("expires in: "+hc.getMaxAge());
                    System.out.println("path is: "+hc.getPath());
                    System.out.println("cookie name is: "+hc.getName());}
            }
        }
		catch(MalformedURLException me){System.out.println("URL exception occurred");}
		catch(IOException ie){System.out.println("IOException occurred");}}}

