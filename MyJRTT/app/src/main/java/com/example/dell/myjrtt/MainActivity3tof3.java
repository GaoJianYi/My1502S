package com.example.dell.myjrtt;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import Utils.UiUtils;


/**
 * data:2017/4/14
 */

public class MainActivity3tof3 extends Activity{


    private ImageView imageView01;
    private ImageView imageView02;
    private int theme = 0;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);
        setContentView(R.layout.f3_two);
        iniView();
    }
    private void iniView() {


     /*   Button Button1_imageview1 = (Button) findViewById(f3_two_image1);
        Button  Button1_imageview2 = (Button) findViewById(R.id.f3_two_image2);*/


    }
}
