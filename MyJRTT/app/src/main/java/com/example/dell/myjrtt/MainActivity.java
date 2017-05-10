package com.example.dell.myjrtt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
Handler han=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(intent);
                finish();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        han.sendEmptyMessageDelayed(0,3000);
    }
}
