package com.example.dell.gaojianyi1502s20170504a.MyUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date:2017/5/4
 * author:高坚译（dell）
 * Time:9:32
 */

public class NetWorkUtile {

    public static boolean isWifi(Context context){

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null && info.getType() == manager.TYPE_WIFI){
            return true;
        }
        return false;
    }
}
