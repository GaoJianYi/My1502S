package com.example.dell.myjrtt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

import Fragment.f1;
import Fragment.f2;
import Fragment.f3;
import Fragment.fragment4;
import Utils.UiUtils;

public class MainActivity1 extends FragmentActivity implements View.OnClickListener{
    private RadioButton bnt1,bnt2,bnt3,bnt4;
    private fragment4 f4;
    private Fragment f0;
    private f1 f1;
    private f2 f2;
    private int theme = 0;
    private f3 f3;
    private long exitTime=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(MainActivity1.this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setTheme(theme);
        setContentView(R.layout.activity_main1);
        initdata();
        if(f1==null){
            f1 = new f1();
        }
        huie(f1);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {

            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else
            {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initdata() {
        bnt1 = (RadioButton) findViewById(R.id.button_b1);
        bnt2 = (RadioButton) findViewById(R.id.button_b2);
        bnt3 = (RadioButton) findViewById(R.id.button_b3);
        bnt4 = (RadioButton) findViewById(R.id.button_b4);
        bnt1.setOnClickListener(this);
        bnt2.setOnClickListener(this);
        bnt3.setOnClickListener(this);
        bnt4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_b1:{
                if(f1==null){
                    f1 = new f1();
                }
                huie(f1);
                break;
            }
            case R.id.button_b2:{
                if(f2==null){
                    f2 = new f2();
                }
                huie(f2);
                break;
            }
            case R.id.button_b3:{
                if(f3==null){
                    f3 = new f3();
                }
                huie(f3);
                break;
            } case R.id.button_b4:{
                if(f4==null){
                    f4 = new fragment4();
                }
                huie(f4);
                break;
            }

        }
    }
    public void huie(Fragment frag){
        FragmentManager smf = getSupportFragmentManager();
        FragmentTransaction bt = smf.beginTransaction();
        if(f0!=null){
            bt.hide(f0);
        }
        //如果Fragment没有被加载过
        if(!frag.isAdded()){
            bt.add(R.id.rlayout,frag);
        }
        bt.show(frag);
        bt.commit();
        f0=frag;
    }
}
