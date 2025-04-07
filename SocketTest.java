import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SocketTest {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("dict.org", 2628);
            OutputStream out = soc.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write("DEFINE gcide Banana\r\n");
            writer.flush();
            InputStream in = soc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
            writer.write("quit\r\n");
            writer.flush();
            soc.close();
        }catch(IOException e){
            System.out.println("I/O error occured");
        }
    }
}
