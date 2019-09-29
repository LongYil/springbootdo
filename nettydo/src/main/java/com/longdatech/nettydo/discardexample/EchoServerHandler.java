package com.longdatech.nettydo.discardexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter { // (1)

    {
        System.out.println("应答服务器处理程序启动。。");
    }
    public EchoServerHandler(){
        super();
        System.out.println("实例化了一个应答服务器处理程序");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
//        ctx.write(msg); // (1)
        ctx.write(1); // (1)
        ctx.flush(); // (2)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}