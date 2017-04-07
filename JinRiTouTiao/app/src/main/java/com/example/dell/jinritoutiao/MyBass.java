package com.example.dell.jinritoutiao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import MyBean.MyBean;

/**
 * date:2017/4/7
 * author:高坚译（dell）
 * Time:21:16
 */

public class MyBass extends BaseAdapter{
    Context context;
    List<MyBean.ListBean> list;

    public MyBass(Context context, List<MyBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder v;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.list,null);
            v=new ViewHoder();
            v.t1= (TextView) convertView.findViewById(R.id.tt1);
            v.t2= (TextView) convertView.findViewById(R.id.tt2);
            convertView.setTag(v);
        }else {
            v= (ViewHoder) convertView.getTag();
        }
        v.t1.setText(list.get(position).getSite_name());
        v.t2.setText(list.get(position).getAddress());
        return convertView;
    }
    class ViewHoder{
        TextView t1,t2;
    }
}
