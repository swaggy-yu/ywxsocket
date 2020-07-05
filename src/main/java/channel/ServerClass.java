package channel;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ServerClass {

    private int port;

    public ServerClass(int port) {
        this.port = port;
    }


    // 服务端进行监听
    public void start() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        //serverSocketChannel.bind(new InetSocketAddress(8080));

        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("服务器监听地址----"+socketChannel.getRemoteAddress());


        while (true){
            Scanner scanner = new Scanner(System.in);

            String msg = MsgUtils.readMsg(socketChannel);

            System.out.println("客户端---"+msg);

            System.out.println("请输入：");

            msg = scanner.nextLine();

            MsgUtils.writeMsg(socketChannel, msg);


        }

    }

    public static void main(String[] args) {
        ServerClass serverClass = new ServerClass(8080);
        try {

            serverClass.start();
        }catch (Exception e){
            e.getMessage();
        }


    }


}
