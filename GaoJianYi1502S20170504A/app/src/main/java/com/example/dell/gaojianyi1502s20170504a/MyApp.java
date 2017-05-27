package com.example.dell.gaojianyi1502s20170504a;

/**
 * date:2017/5/4
 * author:高坚译（dell）
 * Time:9:04
 */

import android.app.Application;

import org.xutils.x;

public  class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
    }
}