import java.net.URLEncoder;
import java.net.URLDecoder;
import java.net.URL;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class EncodeDecode{
    public static void main(String[] args) {
        try{
            String ur = URLEncoder.encode("50$ Bank/s'Transfer", "UTF-8");
            URL url = new URL("http://www.mybank.com/transfer/Query="+ur);
            System.out.println("Encoded URL = "+url);

            String eur = url.toString();
            System.out.println("Decoded URL = "+URLDecoder.decode(eur, "UTF-8"));
        }
        catch(MalformedURLException me){
            System.out.println("URL syntax error. MSG = "+me);
        }
        catch(UnsupportedEncodingException uee){
            System.out.println("Encoding is not supported. MSG = "+uee);
        }
    }
}
