package com.example.dell.myjrtt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.example.xlistview.XListView;
import org.xutils.x;
import Utils.MyXutils;
import Utils.UiUtils;
import isWifi.NetWorkUtile;

public class MainActivityShangChen extends Activity implements View.OnClickListener{
    private XListView xlv;
    private AlertDialog dialog;
    private Handler mHandler;
    private int a=0;
    private int b=0;
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //切换主题必须放在onCreate()之前
        if (savedInstanceState == null) {
            theme = UiUtils.getAppTheme(this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
        setContentView(R.layout.activity_mainsc);
        xlv= (XListView) findViewById(R.id.xlv);
        x.view().inject(this);

        boolean wifi = NetWorkUtile.isWifi(MainActivityShangChen.this);
        xlv.setPullLoadEnable(true);
        xlv.setPullLoadEnable(true);
        if (wifi){
            MyXutils.doGet(MainActivityShangChen.this,xlv,"0","0");
            mHandler = new Handler();
            xlv.setXListViewListener(new XListView.IXListViewListener() {
                @Override
                public void onRefresh() {
                    MyXutils.doGet(MainActivityShangChen.this,xlv,""+a,""+b);
                    xlv.stopRefresh();
                }

                @Override
                public void onLoadMore() {
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MyXutils.doGet(MainActivityShangChen.this,xlv,"1","1");
                            xlv.stopLoadMore();
                        }
                    }, 2000);
                }
            });
        }else {
            View view = View.inflate(this, R.layout.dialog_layoutsc, null);
            dialog = new AlertDialog.Builder(this).create();
            dialog.setView(view);
            dialog.show();
//设置监听
            Button queding = (Button) view.findViewById(R.id.button);
            Button quxiao = (Button) view.findViewById(R.id.button2);
            queding.setOnClickListener(this);
            quxiao.setOnClickListener(this);

        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                open_wifi_auto();
                dialog.dismiss();
                MyXutils.doGet(MainActivityShangChen.this,xlv,"0","0");
                break;
            case R.id.button2:
                a++;b++;
                MyXutils.doGet(MainActivityShangChen.this,xlv,""+a,""+b);
                dialog.dismiss();
                break;
        }
    }
    public void open_wifi_auto()
    {//自动打开WIFI
        WifiManager wifimanager;
        wifimanager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        wifimanager.setWifiEnabled(true);
    }
}
