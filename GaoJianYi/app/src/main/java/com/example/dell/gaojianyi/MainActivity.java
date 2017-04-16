package com.example.dell.gaojianyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.x;

import MyURL.Url;


public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    private TextView t1;
    private ListView lv;
    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        lv1= (ListView) findViewById(R.id.lv1);
        t1= (TextView) findViewById(R.id.t1);
        cehuadata();
        new MyData().MyData2(MainActivity.this,lv1, Url.getPath4);
        t1.setText("全部药品");
    }
    public void cehuadata(){
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        WindowManager wm = getWindowManager();
        //获取整个屏幕的大小
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        float widthPixels = (float) displayMetrics.widthPixels;
        double v = (int) widthPixels * 0.8;
        menu.setBehindWidth((int)v);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.5f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        //设置滑动的屏幕局限，该设置为全屏区域都可以滑动
        //使SlidingMenu附加在Activity上
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(getLeftMenu());
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
    }

    public View getLeftMenu() {
        //从主布局文件绑定的Activity调用另一个布局文件必须调用LayoutInflater
        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.chehua, null);
        lv = (ListView) v.findViewById(R.id.lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    MyData myData = new MyData();
                    myData.MyData2(MainActivity.this,lv1, Url.getPath4);
                    t1.setText("全部药品");
                }else if (position == 2) {
                    MyData myData = new MyData();
                    myData.MyData2(MainActivity.this,lv1, Url.path3);
                    t1.setText("中药");
                }else {
                    MyData myData = new MyData();
                    myData.MyData2(MainActivity.this,lv1, Url.path2);
                    t1.setText("西药");
                }
            }
        });
        MyData myData = new MyData();
        myData.MyData1(this, lv);
        return v;
    }
}
