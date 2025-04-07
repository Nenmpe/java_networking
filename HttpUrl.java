import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;

public class HttpUrl {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.java.com");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) urlConnection;

            System.out.println("Response code: " + http.getResponseCode());
            System.out.println("Response message: " + http.getResponseMessage());
        } catch (MalformedURLException e) {
            System.out.println("Unknown URL");
        } catch (IOException e) {
            System.out.println("I/O error occured");
        }
    }
}
