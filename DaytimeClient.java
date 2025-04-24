import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class DaytimeClient{
	public static void main(String args[]){
		try{
			
			Socket server= new Socket("localhost",3005);
			BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			for(String time = br.readLine();time!=null; time=br.readLine()){
				System.out.println(time);
			}
		}
		catch(IOException iex){System.out.println(iex.getMessage());}
	}
}