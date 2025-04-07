import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.IOException;

public class HttpHeader2 {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.google.com");
            URLConnection urlConnection = url.openConnection();
            
            for(int i = 0; ;i++){
                if(urlConnection.getHeaderField(i) == null) break;
                System.out.println(urlConnection.getHeaderFieldKey(i) + ": " + urlConnection.getHeaderField(i));
            }
        }
        catch(MalformedURLException me){
            System.out.println("Unknown URL");
        }
        catch(IOException ie){
            System.out.println("I/O error occured");
        }
    }
}
