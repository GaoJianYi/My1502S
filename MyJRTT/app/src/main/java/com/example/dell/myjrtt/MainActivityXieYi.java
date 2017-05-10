package com.example.dell.myjrtt;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import Utils.UiUtils;

public class MainActivityXieYi extends Activity implements View.OnClickListener{
    private ImageView bt1;
    private Button bt2;
    private CheckBox cb;
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
        setContentView(R.layout.f4_tiaokuang);
        bt1= (ImageView) findViewById(R.id.f4_tiaokuang_immage_zuo);
        bt1.setOnClickListener(this);
cb= (CheckBox) findViewById(R.id.f4_tiaokuang_checkBox);
        bt2= (Button) findViewById(R.id.f4_tiaokuang_xiayibu);
        bt2.setOnClickListener(this);
        SharedPreferences sp=getSharedPreferences("cb",MODE_PRIVATE);
        boolean my = cb.isInputMethodTarget();
        sp.edit().putBoolean("box",my).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f4_tiaokuang_immage_zuo:
                finish();
                break;
            case R.id.f4_tiaokuang_xiayibu:

                finish();
                break;
    }}
}
