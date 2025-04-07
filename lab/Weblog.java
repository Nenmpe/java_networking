import java.io.*;import java.net.*;
public class Weblog{
	public static void main(String args[]){
		try{
			FileInputStream fin = new FileInputStream(args[0]);
			Reader in = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(in);
			for(String entry = br.readLine(); entry!=null; entry = br.readLine()){
				int indx = entry.indexOf(' ');
				String IP =entry.substring(0,indx);
				String Remaining = entry.substring(indx);
				InetAddress iadd = InetAddress.getByName(IP);
				System.out.println(iadd.getHostName()+" "+ Remaining);
            }	
            br.close();
            }
		catch(UnknownHostException e){System.out.println("unable to resolve the host");}
		catch(IOException ex){System.out.println("IOExeception occured");}
	}}