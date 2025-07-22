package datagram.udp.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpChannelSend{
	public static void main(String args[]){
		try{
			DatagramChannel channel = DatagramChannel.open();
			SocketAddress addr = new InetSocketAddress(1236);
			channel.bind(addr);
			String Message="Hello Server";
			byte[] msg = Message.getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(msg);
			SocketAddress address = new InetSocketAddress("localhost",3001);
			channel.send(buffer,address);
			System.out.println("Message to server: "+Message+" sent");
			buffer.clear();
		}catch(IOException iex){System.out.println(iex.getMessage());}
	}
}