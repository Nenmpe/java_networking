package channel.async_nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class AsyncServer {
	public  static void main(String[] args){
		try{
			AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
			server.bind(new InetSocketAddress("localhost", 5555));
			while(true){
				Future<AsynchronousSocketChannel> acceptConnection = server.accept();
				AsynchronousSocketChannel client = acceptConnection.get(10, TimeUnit.SECONDS);
				if((client != null) && (client.isOpen())){
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					Future<Integer> read = client.read(buffer);
					read.get();
					buffer.flip();
					byte[] fromClient = new byte[buffer.remaining()];
					buffer.get(fromClient);
					System.out.println("Received from client: " + new String(fromClient));
				}
				client.close();
			}
		}catch(Exception e){e.printStackTrace();}
	}    
}
