package com.example.dell.myjrtt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import Utils.UiUtils;

public class MainActivityZhaoHuiMiMa2 extends Activity implements View.OnClickListener{
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
        setContentView(R.layout.activity_yzzhaohuimima);
        initView();
    }
    private void initView() {
        iv1= (ImageView) findViewById(R.id.image_zhaohuimiba2);
        iv1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.image_zhaohuimiba2:
        finish();
        break;
    }}
}
