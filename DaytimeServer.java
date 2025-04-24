import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer{
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(3005);
			while(true){
					Socket connection = server.accept();
					OutputStream os = connection.getOutputStream();
					BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
					Date now = new Date();
					String current = now.toString();
					out.write(current+"\r\n");
					out.flush();
			}
		}
		catch(IOException ie){System.out.println(ie.getMessage());}
	}
}