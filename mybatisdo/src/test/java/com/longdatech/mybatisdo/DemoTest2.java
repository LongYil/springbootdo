package com.longdatech.mybatisdo;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.List;

public class DemoTest2 {
    private static List<Socket> list = new ArrayList<>();

    static {
        new Thread(()->{
            try{
                ServerSocket serverSocket = new ServerSocket(8088);
                while (true){
                    Socket socket = serverSocket.accept();
                    list.add(socket);
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    System.out.println("新用户上线,端口号为:" + socket.getPort() + ",用户信息：" + (new String(bytes)) + "，当前用户数：" + list.size());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

    @Test
    public void test1() throws Exception{
        Socket socket = new Socket("127.0.0.1",8088);
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("qqid:2370775541".getBytes());
        outputStream.flush();
//        SelectorProvider provider = SelectorProvider.provider();
//        Selector selector = provider.openSelector();
    }

    @Test
    public void test12() throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
        socketChannel.configureBlocking(false);

        while (! socketChannel.isConnected()){

        }
    }

    @Test
    public void test13() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel == null){
                System.out.println("有新通道注册啦！");
            }
        }

    }





















}
