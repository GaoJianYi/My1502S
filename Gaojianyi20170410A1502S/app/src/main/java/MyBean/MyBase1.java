package MyBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.gaojianyi20170410a1502s.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;


/**
 * date:2017/4/10
 * author:高坚译（dell）
 * Time:9:16
 */

public class MyBase1 extends BaseAdapter {
    private Context context;
    private List<Bean1.ResultBean.DataBean> list;

    public MyBase1(Context context, List<Bean1.ResultBean.DataBean> list) {
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
            v.iv= (ImageView) convertView.findViewById(R.id.list_imageView);
            v.t1= (TextView) convertView.findViewById(R.id.list_t1);
            v.t2= (TextView) convertView.findViewById(R.id.list_t2);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),v.iv);
        v.t1.setText(list.get(position).getTitle());
        v.t2.setText(list.get(position).getAuthor_name());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView t1,t2;
    }
}
