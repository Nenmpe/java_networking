import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	protected PasswordAuthentication getPasswordAuthentication(){
		String username="admin";
		String password="admin";
		return(new PasswordAuthentication(username, password.toCharArray()));
	}
}
