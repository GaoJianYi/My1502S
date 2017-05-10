package DLQQ;

import android.content.Context;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import static Url.URL_DL.LINK_MOBILE_LOGIN;

/**
 * date:2017/4/21
 * author:高坚译（dell）
 * Time:15:35
 */

public class PostDL {
    Context context;
    private String username;
    private String password;
    public PostDL(Context context, String username, String password) {
        this.context = context;
        this.username = username;
        this.password = password;
    }
    private String url=LINK_MOBILE_LOGIN;
    public void xpust(){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                Log.e("tag", "请求成功============"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("tag", "请求失败============"+error);
            }
        }){
            /**
             * 重写getParams方法设置参数，post添加参数的方法
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String,String>();
                params.put("username", username);
                params.put("password",password);
                return params;
            }
        };
        requestQueue.add(request);
    }}
