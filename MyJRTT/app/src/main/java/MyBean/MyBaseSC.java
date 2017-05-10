package MyBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dell.myjrtt.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.util.List;

/**
 * date:2017/4/24
 * author:高坚译（dell）
 * Time:8:57
 */

public class MyBaseSC extends BaseAdapter {
    private Context context;
    private List<MyBeanShangChen.DataBean> list;

    public MyBaseSC(Context context, List<MyBeanShangChen.DataBean> list) {
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
            convertView=View.inflate(context, R.layout.listsc,null);
            v=new ViewHoder();
            v.iv= (ImageView) convertView.findViewById(R.id.imageView);
            v.t1= (TextView) convertView.findViewById(R.id.t1);
            v.t2= (TextView) convertView.findViewById(R.id.t2);
            v.t3= (TextView) convertView.findViewById(R.id.t3);
            v.t4= (TextView) convertView.findViewById(R.id.t4);
            convertView.setTag(v);
        }else {
            v= (ViewHoder) convertView.getTag();
        }
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        if (list.get(position).getIMAGEURL()!=null){
        ImageLoader.getInstance().displayImage((String) list.get(position).getIMAGEURL(),v.iv);}
        v.t1.setText(list.get(position).getTITLE());
        v.t2.setText(list.get(position).getSUBTITLE());
        v.t3.setText(list.get(position).getFROMNAME());
        v.t4.setText(list.get(position).getSHOWTIME());
        return convertView;
    }
    class ViewHoder{
        ImageView iv;
        TextView t1,t2,t3,t4;
    }
}
