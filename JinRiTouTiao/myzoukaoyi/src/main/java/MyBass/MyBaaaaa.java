package MyBass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myzoukaoyi.R;

import java.util.List;

import MyBean.Bean;

/**
 * date:2017/4/9
 * author:高坚译（dell）
 * Time:18:36
 */

public class MyBaaaaa extends BaseAdapter {
    private Context context;
    private List<Bean.ListBean> list;

    public MyBaaaaa(Context context, List<Bean.ListBean> list) {
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
        ViewHolder v;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.list,null);
            v=new ViewHolder();
            v.t1= (TextView) convertView.findViewById(R.id.list_t2);
            v.t2= (TextView) convertView.findViewById(R.id.list_t4);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        v.t1.setText(list.get(position).getSite_name());
        v.t2.setText(list.get(position).getAddress());
        return convertView;
    }
    class ViewHolder{
        TextView t1,t2;
    }
}
