package com.example.nanoserver;

import java.io.IOException;

import fi.iki.elonen.router.RouterNanoHTTPD;

public class MyClass {

    public static void main(String[] args) {
        NanoServer server = new NanoServer();
        try {
            server.start(RouterNanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}