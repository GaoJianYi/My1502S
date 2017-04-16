package MyBass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gaojianyi.R;

import java.util.List;

import MyBean.MytitleBean;

/**
 * 作者:高伟振
 * 2017/4/15
 * 9:56
 * <p>
 * 类描述:
 */

public class MyTitlebase extends BaseAdapter{
    private Context mContext;
    private List<MytitleBean.DataBean> mList;

    public MyTitlebase(Context context, List<MytitleBean.DataBean> list) {
        mContext = context;
        mList = list;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=convertView.inflate(mContext, R.layout.listv,null);
        TextView tv= (TextView) convertView.findViewById(R.id.chua_tv1);
        tv.setText(mList.get(position).getName());
        return convertView;
    }

}
