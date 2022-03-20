package com.java.nio;

import com.java.nio.gateway.HttpGatewayServer;

public class NettyServerApplication {
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "2.0.0";

    public static void main(String[] args) {
        String proxyServer = "http://localhost:8801";
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        int port = 8080;
        HttpGatewayServer server = new HttpGatewayServer(port, proxyServer);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
