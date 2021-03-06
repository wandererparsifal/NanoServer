package com.example.nanoserver.router;

import com.example.nanoserver.ServerApplication;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

public class HomePageHandler extends RouterNanoHTTPD.DefaultHandler {

    public String getText() {
        InputStream is = ServerApplication.getInstance().getResStream("htmls/index.html");
        String html = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            html = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }

    @Override
    public String getMimeType() {
        return "text/html";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

}