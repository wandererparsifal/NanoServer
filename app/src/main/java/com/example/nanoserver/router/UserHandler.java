package com.example.nanoserver.router;

import com.google.gson.Gson;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

public class UserHandler extends RouterNanoHTTPD.DefaultHandler {

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getMimeType() {
        return null;
    }

    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        UserResponse response = new UserResponse();
        String type = urlParams.get("token");
        if ("90u35b7u98b9478213b57u093ubn4387g493mvh309h4".equals(type)) {
            response.name = "rainbow";
            response.telephone = "13000000000";
            response.address = "Dalian";
            response.occupation = "Employee";
            response.avatar = "http://localhost:8080/public/images/1914475842.jpg";
            return NanoHTTPD.newFixedLengthResponse(getStatus(), "application/json", new Gson().toJson(response));
        }
        return NanoHTTPD.newFixedLengthResponse(getStatus(), "application/json", "{}");
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return RouterNanoHTTPD.Response.Status.OK;
    }

    static class UserResponse {

        String name;

        String telephone;

        String address;

        String occupation;

        String avatar;
    }
}
