package com.example.dell.jinritoutiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import MyBean.MyBean;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private MyBass myBass;
    public static final String url="http://result.eolinker.com/KLn5hSP9f6fed196f92ec0148255a48aebb2c6cc5f97f0e?uri=user";
    private List<MyBean.ListBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        //创建异步线程
        MyAsyncTask my = new MyAsyncTask();
        //开启异步线程
        my.execute(url);
        //通过接口回调获取网络请求的数据
        my.huidiao(new MyAsyncTask.getjson() {
            @Override
            public void getjsonstr(String str) {
                Gson gson = new Gson();//创建一个Gson
                //将获取的json串转换成javaBean
                MyBean jsonBean = gson.fromJson(str, MyBean.class);
                list = jsonBean.getList();//返回集合
                myBass = new MyBass(MainActivity.this, list);
                lv.setAdapter(myBass);//添加适配器
            }
        });//设置条目点击吐丝站点的id
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"该站点的id"+list.get(i).getId(),Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list.remove(i);
                myBass.notifyDataSetChanged();
                return false;

            }
        });
    }
}
