package com.example.dell.myjrtt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;

import Utils.UiUtils;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivityZhaoHuiMiMa extends Activity implements View.OnClickListener{
    private Button bt1,bt2;
    private ImageView iv1;
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);

        setContentView(R.layout.activity_zhaohuimima);
        initView();
        SMSSDK.initSDK(this, "1cfc8f67e3720", "dbe82e103eb31bc9528f0fbfc33ff221");
    }
    private void initView() {
        bt1= (Button) findViewById(R.id.xiayibu);
        iv1= (ImageView) findViewById(R.id.image_zhaohui);
        iv1.setOnClickListener(this);
        bt1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xiayibu:
                //打开注册页面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
// 提交用户信息（此方法可以不调用）
//                            registerUser(country, phone);
                            SharedPreferences yz = getSharedPreferences("YZ", MODE_PRIVATE);
                            yz.edit().putBoolean("yz",false).commit();
                            Intent intent = new Intent(MainActivityZhaoHuiMiMa.this,MainActivityZhaoHuiMiMa2.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                registerPage.show(this);

                break;
            case R.id.image_zhaohui:
                finish();
                break;
        }
    }
}
