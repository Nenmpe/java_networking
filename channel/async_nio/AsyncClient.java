package channel.async_nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class AsyncClient {
    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            Future<Void> connect = client.connect(new InetSocketAddress("localhost", 5555));
            connect.get();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message = reader.readLine();
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            Future<Integer> write = client.write(buffer);
            write.get();
            System.out.println("Sent to server: " + message);
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
