package com.naman14.newsstand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by roshu on 30/4/16.
 */
public class OnMaP extends AppCompatActivity {

    WebView myWebView;


    String mapPath = "https://www.google.com/maps/place/3E+Software+Solutions/@12.9783588,77.6334273,17z/data=!3m1!4b1!4m2!3m1!1s0x3bae16ab6108b0bb:0x999564bf42275500";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nw_map);
        getSupportActionBar().hide();
        myWebView = (WebView)findViewById(R.id.mapview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(mapPath);
    }
}
