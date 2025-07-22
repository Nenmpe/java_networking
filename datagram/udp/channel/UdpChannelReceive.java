package datagram.udp.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpChannelReceive{
	public static void main(String args[]){
		try{
			DatagramChannel receiveChannel = DatagramChannel.open();
			SocketAddress address = new InetSocketAddress(3001);
			receiveChannel.bind(address);
			ByteBuffer buffer = ByteBuffer.allocate(100);
			while(true){
				receiveChannel.receive(buffer);
				buffer.flip();
				byte[] data = new byte[buffer.remaining()];
				buffer.get(data);
				String message = new String(data);
				System.out.println("Message from client: "+message);
				buffer.clear(); }
		}catch(IOException iex){System.out.println(iex.getMessage());}}}