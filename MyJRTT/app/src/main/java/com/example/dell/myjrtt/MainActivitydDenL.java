package com.example.dell.myjrtt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import Utils.UiUtils;

public class MainActivitydDenL extends Activity implements View.OnClickListener{
    private Button bt1,bt2;
    private List<View> list=new ArrayList<>();
    private ImageView iv1;
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

        setContentView(R.layout.activity_gddl);
        initView();

    }

    private void initView() {
        iv1= (ImageView) findViewById(R.id.image_xiaohui);
        iv1.setOnClickListener(this);
        bt1= (Button) findViewById(R.id.shoujihao);
        bt2= (Button) findViewById(R.id.zhucexinzhanghu);
        list.add(bt1);list.add(bt2);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shoujihao:
                Intent intent = new Intent(MainActivitydDenL.this, MainActivitydShouJiDenL.class);
                startActivity(intent);
                finish();
                break;
            case R.id.zhucexinzhanghu:
                Intent intent1 = new Intent(MainActivitydDenL.this, MainActivitydShouJiZhuCe.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.image_xiaohui:
                Intent intent2 = new Intent(MainActivitydDenL.this, MainActivity1.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
