package com.example.nanoserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ServerApplication {

    private ServerApplication() {
    }

    private static class SingletonHolder {
        private final static ServerApplication INSTANCE = new ServerApplication();
    }

    public static ServerApplication getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public InputStream getResStream(String fileName) {
        try {
            return new FileInputStream(System.getProperty("user.dir") + "/javaserver/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
