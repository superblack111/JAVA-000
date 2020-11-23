package io.github.yiwenlong.gateway.inbound;

import io.github.yiwenlong.gateway.client.TargetClient;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class GatewayInboundChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("Receive message from: " + ctx.channel().remoteAddress());
        final ByteBuf input = (ByteBuf) msg;
        log.info("Receive client message: " + input.toString(CharsetUtil.UTF_8));
        final InetSocketAddress innerServiceAddress = new InetSocketAddress("localhost", 8088);
        new TargetClient(ctx)
                .access(innerServiceAddress, input);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
