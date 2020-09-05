package com.example.nanoserver;

import com.example.nanoserver.router.HomePageHandler;
import com.example.nanoserver.router.LoginHandler;
import com.example.nanoserver.router.ResourceHandler;
import com.example.nanoserver.router.UserHandler;
import com.example.nanoserver.router.UserPageHandler;

import fi.iki.elonen.router.RouterNanoHTTPD;

public class NanoServer extends RouterNanoHTTPD {

    public NanoServer() {
        super(8080);
        addMappings();
    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/", HomePageHandler.class);
        addRoute("/public/:type/:fileName", ResourceHandler.class);
        addRoute("/login", LoginHandler.class);
        addRoute("/user/:token", UserHandler.class);
        addRoute("/userinfo/:token", UserPageHandler.class);
    }
}
