package io.github.yiwenlong.gateway;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayServer {

    private int port;
    private int mainGroupThreadCount = 1;
    private int childGroupThreadCount = 1;

    public void start() throws InterruptedException {
        final EventLoopGroup mainGroup = new NioEventLoopGroup(mainGroupThreadCount);
        final EventLoopGroup stubGroup = new NioEventLoopGroup(childGroupThreadCount);

        final ServerBootstrap bootstrap = new ServerBootstrap();
        final InetSocketAddress localAddress = new InetSocketAddress(port);

        bootstrap.group(mainGroup, stubGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(localAddress)
                .childHandler(new GatewayChildChannelInitializer());

        try {
            ChannelFuture future = bootstrap.bind().sync();
            log.info("Gateway Server is listening on: " + localAddress);
            future.channel().closeFuture().sync();
        } finally {
            mainGroup.shutdownGracefully().sync();
            stubGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GatewayServerBuilder()
                .port(9991)
                .mainGroupThreadCount(1)
                .childGroupThreadCount(2)
                .build()
                .start();
    }
}
