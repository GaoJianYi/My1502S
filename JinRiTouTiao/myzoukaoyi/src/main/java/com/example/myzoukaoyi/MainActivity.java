package com.example.myzoukaoyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import MyBass.MyAsyncTask;
import MyBass.MyBaaaaa;
import MyBean.Bean;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    public static final String url="http://result.eolinker.com/KLn5hSP9f6fed196f92ec0148255a48aebb2c6cc5f97f0e?uri=user";
    private List<Bean.ListBean> list = new ArrayList<>();
    private MyBaaaaa ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        //创建异步线程
        MyAsyncTask my = new MyAsyncTask();
        my.execute(url);
        my.huidiao(new MyAsyncTask.getjson() {
            @Override
            public void getjsonstr(String str) {
                Gson gson = new Gson();//创建一个Gson
                //将获取的json串转换成javaBean
                Bean jsonBean = gson.fromJson(str, Bean.class);
                list = jsonBean.getList();//返回集合
                ba= new MyBaaaaa(MainActivity.this, list);
                lv.setAdapter(ba);//添加适配器
            }
        });
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,"此站点ID："+list.get(position).getId(),Toast.LENGTH_SHORT).show();
    }
});
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                ba.notifyDataSetChanged();
                return false;
            }
        });
    }
}
