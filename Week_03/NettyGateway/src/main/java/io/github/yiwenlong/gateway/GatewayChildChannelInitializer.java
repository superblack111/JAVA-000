package io.github.yiwenlong.gateway;

import io.github.yiwenlong.gateway.inbound.GatewayInboundChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class GatewayChildChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new GatewayInboundChannelHandler());
    }
}
