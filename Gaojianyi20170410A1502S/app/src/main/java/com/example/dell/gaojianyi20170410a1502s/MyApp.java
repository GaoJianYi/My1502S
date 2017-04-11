package com.example.dell.gaojianyi20170410a1502s;

import android.app.Application;
import org.xutils.x;

/**
 * date:2017/4/10
 * author:高坚译（dell）
 * Time:15:32
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
    }
}