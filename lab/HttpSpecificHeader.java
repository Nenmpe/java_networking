import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URL;
import java.util.Date;

public class HttpSpecificHeader {
    public static void main(String[] args) {
        try{
			URL ur = new URL("https://www.akamai.com");
			URLConnection uc= ur.openConnection();
			uc.getContent();
			System.out.println("Content type: "+uc.getContentType());
			System.out.println("accessed date:"+new Date(uc.getDate()));
			System.out.println("Content length: "+uc.getContentLength());
			System.out.println("Last Modified: "+new Date(uc.getLastModified()));
			System.out.println("Last Expires in: "+new Date(uc.getExpiration()));
			if(uc.getContentEncoding()!=null){
					System.out.println(uc.getContentEncoding());
            }
        }
		catch(MalformedURLException me){System.out.println("URL error");}
		catch(IOException ie){System.out.println("I/O error");}
    }
}
