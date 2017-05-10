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

public class MyBase3 extends BaseAdapter {
    private Context context;
    private List<Bean1.ResultBean.DataBean> list;

    public MyBase3(Context context, List<Bean1.ResultBean.DataBean> list) {
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
            convertView=View.inflate(context, R.layout.f3_main_item,null);
            v=new ViewHolder();
            v.imageView= (ImageView) convertView.findViewById(R.id.f3_item_image);
            v.textview1= (TextView) convertView.findViewById(R.id.f3_item_t01);
            v.textView2= (TextView) convertView.findViewById(R.id.f3_item_t01_02);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),v.imageView);
        v.textview1.setText(list.get(position).getTitle());
        v.textView2.setText(list.get(position).getAuthor_name());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textview1,textView2;
    }
}
