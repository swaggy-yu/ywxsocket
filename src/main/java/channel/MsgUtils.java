package channel;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MsgUtils {



    public  String readMsg(SocketChannel channel)  throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        int num = channel.read(buffer);

        buffer.flip();
        byte[] res = new byte[ buffer.limit()];

        buffer.get(res);

        return new String(res);
    }

    public  void writeMsg(SocketChannel socketChannel,String msg) throws Exception{

        ByteBuffer write = ByteBuffer.allocate(128);

        write.put(msg.getBytes());

        write.flip();

        socketChannel.write(write);



    }

}
