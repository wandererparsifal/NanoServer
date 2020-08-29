package com.example.nanoserver;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NanoServer server = new NanoServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final WebView webView = findViewById(R.id.wv);
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("http://localhost:8080");
            }
        }, 200);
    }
}