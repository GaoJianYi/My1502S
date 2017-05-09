package com.example.zoukaoa;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HttpUrlDoGet.HttpURLUtlis;

public class MainActivity extends AppCompatActivity {
    public static final String url="http://api.jisuapi.com/weather/city?appkey=b4d06fdd59ed379f";
    private List<String> list1=new ArrayList<>();
    private List<String> list2=new ArrayList<>();
    private Map<List<String>,List<String>> map=new HashMap<>();
    private ExpandableListView lv;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String ss= (String) msg.obj;
            Toast.makeText(MainActivity.this,ss,Toast.LENGTH_SHORT).show();
            Bean bean = new Gson().fromJson(ss, Bean.class);
            List<Bean.ResultBean> result = bean.getResult();
            for (int i = 0; i < result.size(); i++) {
               if (result.get(i).getCityid().equals("0")){
                   list1.add(result.get(i).getCityid());
               }else {
                   list2.add(result.get(i).getCityid());
               }
                map.put(list1,list2);
            }

            My my = new My();
            lv.setAdapter(my);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ExpandableListView) findViewById(R.id.lv);
        new HttpURLUtlis(url,handler).start();
    }

    class My extends BaseExpandableListAdapter{
        @Override
        public int getGroupCount() {
            return map.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return map.get(list2.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return map.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return map.get(list1.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
           ViewHolder v;
            if (convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.list,null);
                v=new ViewHolder();
                v.t1= (TextView) convertView.findViewById(R.id.t1);
                convertView.setTag(v);
            }else {
                v= (ViewHolder) convertView.getTag();
            }
            v.t1.setText("asdsad");
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder v;
            if (convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.list,null);
                v=new ViewHolder();
                v.t1= (TextView) convertView.findViewById(R.id.t1);
                convertView.setTag(v);
            }else {
                v= (ViewHolder) convertView.getTag();
            }
            v.t1.setText("bbbbbbb");
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
        class ViewHolder{
            TextView t1;
        }
    }
}
