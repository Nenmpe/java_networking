import java.io.*;
import java.net.*;

public class URLContentFetcher {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.java.com/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
            is.close();

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
