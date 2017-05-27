package com.example.dell.gaojianyi1502s20170504a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class MainActivity1 extends Activity {
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main1);
        wv= (WebView) findViewById(R.id.wv);
//        MyXutilsGet.Xget(this,wv);
//        String url = new Gson().fromJson(URl.json1, MyBean.class).getApp().get(0).getUrl();
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        wv.loadUrl(url);
    }
}
