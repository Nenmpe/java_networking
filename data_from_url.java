import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class data_from_url {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://www.java.com");
            URLConnection uc = u.openConnection();
            InputStream is = uc.getInputStream();
            int a;
            while((a=is.read())!=-1){
                System.out.print((char)a);
            }
            is.close();
        }catch(MalformedURLException me){
            System.out.println(me);
        }catch(IOException ie){
            System.out.println(ie +": IO Exception");
        }

    }
}
