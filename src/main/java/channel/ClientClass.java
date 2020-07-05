package channel;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientClass {

    public void start() throws Exception{

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.bind(new InetSocketAddress("127.0.0.1",8080));

        while (true){
            Scanner scanner =new Scanner(System.in);
            System.out.println("请输入：");

            String msg = scanner.nextLine();
            MsgUtils msgUtils =new MsgUtils();

            msgUtils.writeMsg(socketChannel,msg);


            String msg1 = msgUtils.readMsg(socketChannel);

            System.out.println("----------"+msg);



        }





    }

    public static void main(String[] args) {
        ClientClass c = new ClientClass();
        try {
            c.start();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
