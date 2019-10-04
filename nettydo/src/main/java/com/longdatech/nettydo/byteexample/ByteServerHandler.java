package com.longdatech.nettydo.byteexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.buffer.PooledByteBufAllocator;

import java.nio.ByteBuffer;

public class ByteServerHandler extends ChannelInboundHandlerAdapter {

    public ByteServerHandler() {
        System.out.println("实例化消息处理器。。");
    }

    //    @Override
//    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        System.out.println("请求已到达。。。");
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeBytes("hi".getBytes());
//
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
//                ctx.close();
//            }
//        }); // (4)
//    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive:");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead:");
        System.out.println(msg);
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] bytes = byteBuf.array();
//        System.out.println(new String(bytes));
        PooledByteBufAllocator p = new PooledByteBufAllocator();
        ByteBuf buffer = (ByteBuf)msg;

        int b = buffer.readableBytes();

        byte[] bytes = new byte[1024];

        buffer.readBytes(bytes);
        System.out.println(new String(bytes));
    }
}