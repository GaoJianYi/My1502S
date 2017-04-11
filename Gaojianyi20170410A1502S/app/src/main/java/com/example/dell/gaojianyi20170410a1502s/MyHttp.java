package com.example.dell.gaojianyi20170410a1502s;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import MyBean.Bean1;
import MyBean.MyBase1;
import Url.Url;

/**
 * date:2017/4/10
 * author:高坚译（dell）
 * Time:15:35
 */

public class MyHttp {
    private Context context;
    private String str;
    private ListView lv;
    public MyHttp(Context context,
            String str,ListView lv) {
        this.context = context;
        this.str = str;
        this.lv = lv;
    }

    public void Get(){
        RequestParams params = new RequestParams(Url.url);
        params.addQueryStringParameter("uri",str);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                Bean1 bean = new Gson().fromJson(result, Bean1.class);
                List<Bean1.ResultBean.DataBean> data1 = bean.getResult().getData();
//                Toast.makeText(context,data1.toString(),Toast.LENGTH_SHORT).show();
                lv.setAdapter(new MyBase1(context,data1));
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
