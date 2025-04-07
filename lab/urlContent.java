import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class urlContent {
    public static void main(String[] args) {
        try{

            URL ur = new URL("https://tuexam.edu.np/");
            
            URLConnection uc = ur.openConnection();
            
            InputStream is = uc.getInputStream();
            
            int a;
            
            while((a=is.read())!=-1){
            
            System.out.print((char)a);
            
            }
            
            is.close();
            
            }
            catch(MalformedURLException mue){
                System.out.println("ME Exception occurred");
            }
            
            catch(IOException ioex){
            
            System.out.println("IOE error occurred");
            
            }
    }
}
