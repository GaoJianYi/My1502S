package com.example.dell.myjrtt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

import Utils.MyPanDuanSJH;
import Utils.UiUtils;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivitydShouJiZhuCe extends Activity implements View.OnClickListener{
    private Button bt1,bt2,bt3;
    private ImageView iv;
    private EditText et1,et2;
    private String s;
    private String s1;
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zhucexinzhanghu);
        bt1= (Button) findViewById(R.id.button_zhuce_duanxin);
        bt1.setOnClickListener(this);
        bt2= (Button) findViewById(R.id.xieyi);
        bt2.setOnClickListener(this);
        bt3= (Button) findViewById(R.id.xiayibu);
        bt3.setOnClickListener(this);
        iv= (ImageView) findViewById(R.id.image_zhuce);
        iv.setOnClickListener(this);
        et1= (EditText) findViewById(R.id.shuru);
        et2= (EditText) findViewById(R.id.f4_edt_mima);
        SMSSDK.initSDK(this, "1cfc8f67e3720", "dbe82e103eb31bc9528f0fbfc33ff221");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_zhuce_duanxin:
                s = et1.getText().toString();
                s1 = et2.getText().toString();
                boolean matchered = MyPanDuanSJH.isMatchered(MyPanDuanSJH.PHONE_PATTERN, s);
                if (matchered==false){
                    s1 =null;
                    Toast.makeText(MainActivitydShouJiZhuCe.this,"请正确填写手机号",Toast.LENGTH_LONG).show();

                }else if(s1.length()!=6){
                    Toast.makeText(MainActivitydShouJiZhuCe.this,"密码为6位",Toast.LENGTH_LONG).show();
                }
                else if (s1 !=null&&matchered==true){

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



//                            new Post(MainActivitydShouJiZhuCe.this, s,s1,s1,"android", "9876@qq.com").xpust();




                            finish();
                        }else {
                            Toast.makeText(MainActivitydShouJiZhuCe.this,"请确认是否注册",Toast.LENGTH_LONG).show();

                        }
                    }
                });
                registerPage.show(this);}
                break;
            case R.id.image_zhuce:
                Intent intent1 = new Intent(this,MainActivity1.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.xieyi:
                Intent intent = new Intent(this,MainActivityXieYi.class);
                startActivity(intent);
                break;
            case R.id.xiayibu:
                SharedPreferences yz = getSharedPreferences("YZ", MODE_PRIVATE);
                  if (yz.getBoolean("yz",true)==false){
                           Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                      yz.edit().putBoolean("yz",true).commit();
                  }else {
                           Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
                        }

                break;
        }
    }
}
