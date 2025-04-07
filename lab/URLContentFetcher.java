import java.io.*;
import java.net.*;

public class URLContentFetcher {
    public static void main(String[] args) {
        try {
            // Define the target URL
            URL url = new URL("https://tuexam.edu.np/");
            
            // Open connection
            URLConnection connection = url.openConnection();

            // Set a User-Agent to avoid bot blocking
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Open input stream to read content
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read and display content
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            reader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
