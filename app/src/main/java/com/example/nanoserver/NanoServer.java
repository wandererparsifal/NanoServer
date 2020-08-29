package com.example.nanoserver;

import fi.iki.elonen.router.RouterNanoHTTPD;

public class NanoServer extends RouterNanoHTTPD {

    public NanoServer() {
        super(8080);
        addMappings();
    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/", IndexHandler.class);
    }
}
