package com.example.dell.myjrtt;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;


/**
 * date:2017/4/18
 * author:高坚译（dell）
 * Time:8:51
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能3
    }
    {
        PlatformConfig.setQQZone("1106107710", "nZ67cfM1k3SN2iqc");
   }
}