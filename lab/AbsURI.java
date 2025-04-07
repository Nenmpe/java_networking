import java.net.URI;
import java.net.URISyntaxException;
public class AbsURI{
	public static void main(String[] args){
		try{
			URI absolute = new URI("https://www.java.com/");
			URI relative = new URI("FAQ/faq.html");
			URI resolved = absolute.resolve(relative);
			System.out.println("The created absolute URL is "+resolved);	
		}
		catch(URISyntaxException u){System.out.println("URI syntax Error");}
	}
}
