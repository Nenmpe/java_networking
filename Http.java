import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Date;
import java.io.IOException;

public class Http {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.java.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            Date date, expDate, lDate;

            date = new Date(urlConnection.getDate());
            expDate = new Date(urlConnection.getExpiration());
            lDate = new Date(urlConnection.getLastModified());

            System.out.println("Content Type: "+urlConnection.getContentType());
            System.out.println("Content Length: "+urlConnection.getContentLength());
            System.out.println("Content Encoding: "+urlConnection.getContentEncoding());
            System.out.println("Date: "+date);
            System.out.println("Expiration: "+expDate);
            System.out.println("Last Modified: "+lDate);

            System.out.println("---------------------------------");

            
        }
        catch(MalformedURLException me){
            System.out.println("Unknown URL");
        }
        catch(IOException ie){
            System.out.println("I/O error occured");
        }
    }
}
