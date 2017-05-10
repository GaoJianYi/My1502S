package com.example.dell.myjrtt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import Utils.UiUtils;
public class MainActivityWeb extends Activity {
    private WebView wv;
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");
        wv= (WebView) findViewById(R.id.wv);
        wv.loadUrl(url);
    }
}
