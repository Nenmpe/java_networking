import java.net.*;
import java.io.*;

public class AuthDemo{
	public static void main(String[] args){
		try{
			MyAuthenticator ma = new MyAuthenticator();
			Authenticator.setDefault(ma);
			URL ur = new URL("https://www.java.com");
			InputStream is = ur.openStream();
			ma.getPasswordAuthentication();	
			int a;
			while((a=is.read())!=-1){
				System.out.print((char)a);}
			is.close();
		}
		catch(MalformedURLException me){System.out.println("Syntax/protocol Error");}
		catch(IOException ie){System.out.println("IO Exception occurred");}}
}
