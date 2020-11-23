package io.github.yiwenlong.gateway.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
@AllArgsConstructor
public class TargetClient {

    private ChannelHandlerContext ctxOuter;

    public ChannelFuture access(final InetSocketAddress address, final ByteBuf input) {
        return new Bootstrap()
                .channel(NioSocketChannel.class)
                .handler(new ClientChannelHandler(input))
                .group(ctxOuter.channel().eventLoop())
                .connect(address)
                .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }

    @AllArgsConstructor
    final class ClientChannelHandler extends ChannelInboundHandlerAdapter {

        private final ByteBuf input;

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("Get reply message from target service: " + ((ByteBuf) msg).toString(CharsetUtil.UTF_8));
            log.info("Send service reply message to client: " + ctxOuter.channel().remoteAddress());
            ctxOuter.writeAndFlush(msg)
                    .addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            log.info("Send message to target service on: " + ctx.channel().remoteAddress());
            ctx.channel().writeAndFlush(input);
        }
    }
}
