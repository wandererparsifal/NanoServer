package com.example.nanoserver;

import com.example.nanoserver.router.HomeHandler;
import com.example.nanoserver.router.ResourceHandler;

import fi.iki.elonen.router.RouterNanoHTTPD;

public class NanoServer extends RouterNanoHTTPD {

    public NanoServer() {
        super(8080);
        addMappings();
    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/", HomeHandler.class);
        addRoute("/public/:type/:fileName", ResourceHandler.class);
    }
}
