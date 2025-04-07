import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) {
        try{
				URL ur = new URL("https://www.java.com");
				Class<?>[] types = new Class[3];
				types[0] = String.class;
				types[1] = Reader.class;
				types[2] = InputStream.class;
				Object ob = ur.getContent(types);
				if(ob instanceof String){
					System.out.println("String");
					System.out.println(ob);}
				else if(ob instanceof Reader){
                    System.out.println("Reader");
					int a;
					Reader rd = (Reader)ob;
					while((a=rd.read())!=-1){
						System.out.print((char)a);
						}
                        rd.close();
				}
                else if(ob instanceof InputStream){
                    System.out.println("InputStream");
					InputStream is = (InputStream)ob;
					int a;
					while((a=is.read())!=-1){
						System.out.print((char)a);
					}
                    is.close();
				}
				else{
					System.out.print(ob.getClass().getName());
				}
			}
			catch(IOException ex){
				System.out.println("IOExecption occurred");
			}

    }
}
