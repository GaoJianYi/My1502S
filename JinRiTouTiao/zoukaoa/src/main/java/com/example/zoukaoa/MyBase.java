package com.example.zoukaoa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date:2017/4/9
 * author:高坚译（dell）
 * Time:19:57
 */

public class MyBase extends BaseExpandableListAdapter{
    private Context context;
    private List<String> list1;
    private List<String> list2;
    private Map<List<String>,List<String>> map=new HashMap<>();

    public MyBase(Context context, Map<List<String>, List<String>> map, List<String> list2, List<String> list1) {
        this.context = context;
        this.map = map;
        this.list2 = list2;
        this.list1 = list1;
    }

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
            convertView=View.inflate(context,R.layout.list,null);
            v=new ViewHolder();
            v.t1= (TextView) convertView.findViewById(R.id.t1);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        v.t1.setText(list1.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.list,null);
            v=new ViewHolder();
            v.t1= (TextView) convertView.findViewById(R.id.t1);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        v.t1.setText(list2.get(groupPosition));
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