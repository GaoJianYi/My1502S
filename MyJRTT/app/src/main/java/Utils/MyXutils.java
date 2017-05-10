package Utils;

import android.content.Context;
import com.example.xlistview.XListView;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.ArrayList;
import java.util.List;
import MyBean.MyBaseSC;
import MyBean.MyBeanShangChen;
import Url.Url;

/**
 * date:2017/4/24
 * author:高坚译（dell）
 * Time:8:50
 */

public class MyXutils {
    private static List<MyBeanShangChen.DataBean> list=new ArrayList<>();
    public static void doGet(final Context context, final XListView xlv, final String s, final String ss){
        RequestParams params = new RequestParams(Url.url1);
        params.addQueryStringParameter("channelId",s);
        params.addQueryStringParameter("startNum",ss);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //解析result
                List<MyBeanShangChen.DataBean> data =  new Gson().fromJson(result, MyBeanShangChen.class).getData();
                if (s.equals("0")||ss.equals("0")){
                    list.clear();
                    for (int i = 0; i < data.size(); i++) {
                        list.add(data.get(i));
                    }
                    MyBaseSC myBase = new MyBaseSC(context, data);
                xlv.setAdapter(myBase);
            }else {
                    for (int i = 0; i < data.size(); i++) {
                        list.add(data.get(i));
                    }
                    MyBaseSC myBase = new MyBaseSC(context,list);
                    xlv.setAdapter(myBase);
                }
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
