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
import static Url.URL_DL.LINK_MOBILE_REG;

/**
 * date:2017/4/21
 * author:高坚译（dell）
 * Time:15:35
 */

public class Post {
    Context context;
    private String username;
    private String password;
    private String password_confirm;
    private String client;
    private String email;
    public Post(Context context,String username, String password,String password_confirm, String client, String email) {
        this.context = context;
        this.username = username;
        this.password = password;
        this.password_confirm = password_confirm;
        this.client = client;
        this.email = email;
    }
    private String url=LINK_MOBILE_REG;
    public void xpust(){
        //创建RequestQueue对象
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
                params.put("password_confirm",password_confirm);
                params.put("client",client);
                params.put("email",email);
                return params;
            }
        };
        requestQueue.add(request);
    }
}
