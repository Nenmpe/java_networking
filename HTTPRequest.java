import java.net.*;
import java.io.*;

public class HTTPRequest {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.bhaktapur.com");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestMethod("GET");

            System.out.println("Response code: " + http.getResponseCode());
            System.out.println("Response message: " + http.getResponseMessage());


            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            reader.close(); 

            System.out.println("\nResponse Body:");
            System.out.println(response.toString());


        }catch(MalformedURLException e){
            System.out.println("Unknown URL");
        }catch(IOException e){
            System.out.println("I/O error occured");
        }
    }
}
