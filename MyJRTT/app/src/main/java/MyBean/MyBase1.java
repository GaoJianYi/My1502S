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


public class MyBase1 extends BaseAdapter {
    private Context context;
    private List<Bean1.ResultBean.DataBean> list;
    private String url111;
    private static final int BUJUYI=0;
    private static final  int BUJUER=1;
    private static final  int BUJUSAN=2;
    private static final  int BUJUSI=3;

    public MyBase1(Context context, List<Bean1.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {

        String thumbnail_pic_s = list.get(position).getThumbnail_pic_s();
        String thumbnail_pic_s02 = list.get(position).getThumbnail_pic_s02();
        String thumbnail_pic_s03 = list.get(position).getThumbnail_pic_s03();
        if (!"".equals(thumbnail_pic_s03) && !"".equals(thumbnail_pic_s) && !"".equals(thumbnail_pic_s02)
                && thumbnail_pic_s!=null && thumbnail_pic_s02!=null && thumbnail_pic_s03 !=null) {
            return BUJUSI;
        }else if (!"".equals(thumbnail_pic_s) && !"".equals(thumbnail_pic_s02) && thumbnail_pic_s!=null && thumbnail_pic_s02 !=null) {
            return BUJUSAN;
        }else if (!"".equals(thumbnail_pic_s) && thumbnail_pic_s!=null){
            return BUJUER;
        }else {
            return BUJUYI;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 4;
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
        int itemViewType = getItemViewType(position);
        ViewHolder222 v999=null;
        ViewHolder2 v992=null;
        ViewHolder3 v993=null;
        ViewHolder4 v994=null;
        if (convertView==null) {

            switch (itemViewType){

                case BUJUYI:
                    v993=new ViewHolder3();
                    convertView=convertView.inflate(context, R.layout.listvv3,null);
                    v993.tv1= (TextView) convertView.findViewById(R.id.lv3_tv1);
                    v993.tv2= (TextView) convertView.findViewById(R.id.lv3_tv2);
                    convertView.setTag(v993);
                    break;
                case BUJUER:
                    v999=new ViewHolder222();
                    convertView=convertView.inflate(context, R.layout.listvv,null);
                    v999.tv1= (TextView) convertView.findViewById(R.id.fr_tvv1);
                    v999.img= (ImageView) convertView.findViewById(R.id.fr_img);
                    convertView.setTag(v999);
                    break;
                case BUJUSAN:
                    v994=new ViewHolder4();
                    convertView=convertView.inflate(context, R.layout.listvv4,null);
                    v994.tv1= (TextView) convertView.findViewById(R.id.lv4_TV1);

                    v994.img= (ImageView) convertView.findViewById(R.id.lv4_img1);
                    v994.img2= (ImageView) convertView.findViewById(R.id.lv4_img2);
                    convertView.setTag(v994);
                    break;
                case BUJUSI:
                    v992=new ViewHolder2();
                    convertView=convertView.inflate(context, R.layout.listvv2,null);
                    v992.tv1= (TextView) convertView.findViewById(R.id.lv2_TV1);
                    v992.img= (ImageView) convertView.findViewById(R.id.lv2_img1);
                    v992.img2= (ImageView) convertView.findViewById(R.id.lv2_img2);
                    v992.img3= (ImageView) convertView.findViewById(R.id.lv2_img3);
                    convertView.setTag(v992);
                    break;
            }


        }else {
            switch (itemViewType){
                case BUJUYI:
                    v993= (ViewHolder3) convertView.getTag();
                    break;
                case BUJUER:
                    v999= (ViewHolder222) convertView.getTag();
                    break;
                case BUJUSAN:
                    v994=(ViewHolder4)convertView.getTag();
                    break;
                case BUJUSI:
                    v992= (ViewHolder2) convertView.getTag();
                    break;
            }
        }
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        switch (itemViewType){
            case BUJUYI:
                v993.tv1.setText(list.get(position).getAuthor_name());
                v993.tv2.setText(list.get(position).getTitle());
                break;
            case BUJUER:
                v999.tv1.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),v999.img);

                break;
            case BUJUSAN:

                v994.tv1.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),v994.img);

                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),v994.img);

                break;
            case BUJUSI:
                v992.tv1.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),v992.img);
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),v992.img2);
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),v992.img3);
                break;
        }

        return convertView;
    }
    class ViewHolder222{
        private TextView tv1,tv2;
        private ImageView img;
    }
    class ViewHolder2{
        private TextView tv1;
        private ImageView img,img2,img3;
    }
    class ViewHolder3{
        private TextView tv1,tv2;
    }
    class ViewHolder4{
        private TextView tv1;
        private ImageView img,img2;
    }
}
