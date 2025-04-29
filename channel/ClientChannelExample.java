package channel;

import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientChannelExample {
    public static void main(String[] args) {
        try {
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress("localhost", 3001));
            while (!clientChannel.finishConnect()) {}
            System.out.println("Connected to server!");
            BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
            String toServer = brd.readLine();
            ByteBuffer buffer = ByteBuffer.wrap(toServer.getBytes());
            clientChannel.write(buffer);
            System.out.println("Message Sent to Server: "+toServer);
            clientChannel.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
