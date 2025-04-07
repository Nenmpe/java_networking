import java.net.URL;

import java.net.MalformedURLException;

import java.io.IOException;

import java.io.InputStream;

public class url_content{

public static void main(String[] args){

try{

URL ur = new URL("https://www.java.com");

InputStream is = ur.openStream();

int a;

while((a=is.read())!=-1){System.out.print((char)a);}

is.close();}

catch(MalformedURLException mue){System.out.println("Exception occured");}

catch(IOException oex){System.err.println(oex);}

}

}