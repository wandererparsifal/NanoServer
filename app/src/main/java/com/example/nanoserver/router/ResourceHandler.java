package com.example.nanoserver.router;

import android.util.Log;

import com.example.nanoserver.ServerApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

public class ResourceHandler extends RouterNanoHTTPD.DefaultHandler {

    private static final String TAG = ResourceHandler.class.getSimpleName();

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getMimeType() {
        return null;
    }

    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        String type = urlParams.get("type");
        String fileName = urlParams.get("fileName");
        Log.e(TAG, "get type " + type + ", fileName " + fileName);

        String mime = null;
        switch (type) {
            case "images":
                mime = "image/jpeg";
                break;
            case "javascripts":
                mime = "application/x-javascript ";
                break;
            case "stylesheets":
                mime = "text/css ";
                break;
            default:
                break;
        }

        InputStream inputStream = ServerApplication.getInstance().getResStream("public/" + type + "/" + fileName);
        try {
            return NanoHTTPD.newFixedLengthResponse(getStatus(), mime, inputStream, inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RouterNanoHTTPD.Response.IStatus getStatus() {
        return RouterNanoHTTPD.Response.Status.OK;
    }
}