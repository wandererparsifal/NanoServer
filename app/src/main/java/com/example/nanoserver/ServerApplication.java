package com.example.nanoserver;

import android.app.Application;

import java.io.IOException;
import java.io.InputStream;

public class ServerApplication extends Application {

    private static ServerApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static ServerApplication getInstance() {
        return mApplication;
    }

    public InputStream getResStream(String fileName) {
        try {
            return getResources().getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
