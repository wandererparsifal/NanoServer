package com.example.nanoserver.router;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

public class LoginHandler extends RouterNanoHTTPD.DefaultHandler {

    private static final String TAG = LoginHandler.class.getSimpleName();

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getMimeType() {
        return null;
    }

    @Override
    public NanoHTTPD.Response post(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        LoginResponse response = new LoginResponse();
        if (session.getMethod() == RouterNanoHTTPD.Method.POST) {
            try {
                session.parseBody(new HashMap<String, String>());
            } catch (IOException | NanoHTTPD.ResponseException e) {
                e.printStackTrace();
            }
            Map<String, List<String>> map = session.getParameters();
            if (!map.isEmpty()) {
                LoginBean loginBean = new LoginBean();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if ("data".equals(entry.getKey())) {
                        String json = entry.getValue().get(0);
                        loginBean = new Gson().fromJson(json, LoginBean.class);
                    }
                }

                if ("rainbow".equals(loginBean.name) && "123456".equals(loginBean.password)) {
                    response.result = true;
                    response.token = "90u35b7u98b9478213b57u093ubn4387g493mvh309h4";
                } else {
                    response.errorMsg = "username or password is wrong";
                }
            }
            return RouterNanoHTTPD.newFixedLengthResponse(getStatus(), "application/json", new Gson().toJson(response));
        }
        response.result = false;
        response.errorMsg = "unknown error";
        return RouterNanoHTTPD.newFixedLengthResponse(getStatus(), "application/json", new Gson().toJson(response));
    }

    @Override
    public RouterNanoHTTPD.Response.IStatus getStatus() {
        return RouterNanoHTTPD.Response.Status.OK;
    }

    static class LoginBean {

        String name;

        String password;

        @Override
        public String toString() {
            return "LoginBean{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    static class LoginResponse {

        boolean result;

        String token;

        String errorMsg;
    }
}
