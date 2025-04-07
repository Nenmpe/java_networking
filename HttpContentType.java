import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

public class HttpContentType {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.java.com/home/index/index.html");
            String typeFromString = URLConnection.guessContentTypeFromName(url.getPath());
            System.out.println("Content type: " + typeFromString);
        }
        catch(MalformedURLException me){
            System.out.println("Unknown URL");
        }
    }
}
