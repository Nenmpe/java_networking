import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;

public class url_class {
    
    public static void main(String[] args) {
        try{
            URL u = new URL("https://www.java.com");
            InputStream is = u.openStream();
            int a;
            while((a=is.read())!=-1){
                System.out.print((char)a);
            }
            is.close();
        }catch(MalformedURLException me){
            System.out.println(me);
        }catch(IOException ie){
            System.out.println(ie +"IO");
        }

    }
}
