package MyBass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gaojianyi.R;

import java.util.List;

import MyBean.MyBean1;

public class MyBasedata extends BaseAdapter {
    private Context mContext;
    private List<MyBean1.DataBean> list;
    public MyBasedata(List<MyBean1.DataBean> list, Context context) {
        this.list = list;
        mContext = context;
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
        convertView=convertView.inflate(mContext, R.layout.listv2,null);
        TextView tv1= (TextView) convertView.findViewById(R.id.tity_tv1);
        TextView tv2= (TextView) convertView.findViewById(R.id.tity_tv2);
        TextView tv3= (TextView) convertView.findViewById(R.id.tity_tv3);
        tv1.setText(list.get(position).getTitle());
        tv2.setText(list.get(position).getApply());
        tv3.setText(list.get(position).getBuy_price());
        return convertView;
    }
}
