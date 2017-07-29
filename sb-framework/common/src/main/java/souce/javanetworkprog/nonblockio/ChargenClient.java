package souce.javanetworkprog.nonblockio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by sam on 17-7-29.
 * 一个基于通道的chargen客户端.
 */
public class ChargenClient {
    public static int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Chargen host [port]");
            return;
        }

        int port;
        try {
            port = Integer.parseInt(args[1]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }

        try {
            SocketAddress address = new InetSocketAddress(args[0], port);
            SocketChannel client = SocketChannel.open(address);

            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);

            while (client.read(buffer) != -1) {
                buffer.flip(); // 使得输出通道会从所读取数据的开头而不是末尾开始写入
                out.write(buffer);
                buffer.clear(); // 缓冲区重置为初始状态
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
