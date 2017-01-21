package com.hanbit2007.kakao.presentation.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hanbit2007.kakao.R;

public class WriteMsgActivity extends AppCompatActivity implements View.OnClickListener{
    WebView mWebView;
    WebSettings mWebSettings;
//    MessageService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_msg);

        Intent intent = this. getIntent();
        String phone = intent.getExtras().getString("phone");

//        service = new MessageServiceImpl(this.getApplicationContext());

        mWebView = (WebView) findViewById(R.id.mWebview);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.addJavascriptInterface(new javascriptInterface(this), "Hybrid");
        mWebView.loadUrl("file:///android_asset/www/message_write.html");

    }

    @Override
    public void onClick(View v) {

    }
}
