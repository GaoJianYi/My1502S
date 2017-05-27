package com.example.dell.gaojianyi1502s20170504a.MyUtils;

import android.content.Context;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.dell.gaojianyi1502s20170504a.MyBean.MyBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import static com.example.dell.gaojianyi1502s20170504a.MyUtils.URl.url;

/**
 * date:2017/5/4
 * author:高坚译（dell）
 * Time:9:05
 */

public class MyXutilsGet {
    public static void Xget(final Context con,final WebView wv){
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                String url = new Gson().fromJson(result, MyBean.class).getApp().get(0).getUrl();
                wv.loadUrl(url);
                Toast.makeText(con,url,Toast.LENGTH_SHORT).show();
                //解析result
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
}
