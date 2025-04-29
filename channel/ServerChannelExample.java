package channel;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.io.IOException;

public class ServerChannelExample {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(3001));
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while(it.hasNext()){
                    SelectionKey key = it.next();

                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel)key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        SelectionKey clientKey = client.register(selector, SelectionKey.OP_READ);
                        ByteBuffer buffer = ByteBuffer.allocate(106);                        clientKey.attach(buffer);
                    }
                    if(key.isReadable()){
                        SocketChannel client = (SocketChannel)key.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        client.read(buffer);
                        buffer.flip();
                        byte[] fromClient = new byte[buffer.remaining()];
                        buffer.get(fromClient);
                        System.out.println("Received from client: " + new String(fromClient));
                        client.close();
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
