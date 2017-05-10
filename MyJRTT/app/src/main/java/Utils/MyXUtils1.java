package Utils;

import android.os.Handler;
import android.os.Message;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/4/20.
 * time:
 * author:付智焱
 */

public class MyXUtils1 {
    private Handler han;
    private String url;

    public MyXUtils1(Handler han, String url, String canshu) {
        this.han = han;
        this.url = url;
        this.canshu = canshu;
    }

    private String canshu;
    public  void Get(){
        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("uri",canshu);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result请求后获得到的字符串
                Message mess = new Message();
                mess.what=1;
                mess.obj=result;
                han.sendMessage(mess);
            }

            @Override//请求发生异常是回调的方法
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override//网络请求取消是回掉的方法
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}

