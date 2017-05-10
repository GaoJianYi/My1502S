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

import Utils.UiUtils;

public class MainActivitydShouJiDenL extends Activity implements View.OnClickListener{
    private Button bt1,bt2,bt3;
    private ImageView iv1;
    private EditText et1,et2;
    private SharedPreferences.Editor edit;
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
        setContentView(R.layout.activity_shoujihaodenglu);
        initView();
    }
    private void initView() {
        et1= (EditText) findViewById(R.id .sjh);
        et2= (EditText) findViewById(R.id.mm);
        iv1= (ImageView) findViewById(R.id.image_shoujiden);
        iv1.setOnClickListener(this);
        bt1= (Button) findViewById(R.id.wangjimima);
        bt1.setOnClickListener(this);
        bt2= (Button) findViewById(R.id.shouji_denglu);
        bt2.setOnClickListener(this);
        bt3= (Button) findViewById(R.id.zhuce);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wangjimima:
                Intent intent1 = new Intent(MainActivitydShouJiDenL.this,MainActivityZhaoHuiMiMa.class);
                startActivity(intent1);
                break;
            case R.id.image_shoujiden:
                Intent intent12 = new Intent(MainActivitydShouJiDenL.this,MainActivity1.class);
                startActivity(intent12);
                finish();
            case R.id.shouji_denglu:
                String s=et1.getText().toString();
                String ss=et2.getText().toString();


//                new PostDL(MainActivitydShouJiDenL.this,s,ss).xpust();



                if (s!=null&&ss!=null&&!s.equals("")&&!ss.equals("")){
                    SharedPreferences zt = getSharedPreferences("ZT", MODE_PRIVATE);
                    edit = zt.edit();
                    edit.putBoolean("zt",true);
                    edit.putString("sj",s);
                    edit.commit();
                    Toast.makeText(this,"已登录",Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(MainActivitydShouJiDenL.this,MainActivity1.class);
                    startActivity(intent2);
                    finish();
                }
                break;
            case R.id.zhuce:
                Intent intent = new Intent(MainActivitydShouJiDenL.this,MainActivitydShouJiZhuCe.class);
                startActivity(intent);
                break;
        }
    }
}
