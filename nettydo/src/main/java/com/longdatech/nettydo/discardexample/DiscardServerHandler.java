package com.longdatech.nettydo.discardexample;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
//        ((ByteBuf) msg).release(); // (3)
        Object obj = msg;
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                byte[] bytes = new byte[in.readableBytes()];
                in.readBytes(bytes);
//                System.out.print((char) in.readByte());
                System.out.println(new String(bytes,"UTF-8"));
                System.out.flush();
                ctx.write("收到！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}