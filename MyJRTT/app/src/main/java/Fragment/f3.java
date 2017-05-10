package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.dell.myjrtt.MainActivity3tof3;
import com.example.dell.myjrtt.R;
import com.google.gson.Gson;
import java.util.List;
import HttpUrlDoGet.HttpURLUtlis;
import MyBean.Bean1;
import MyBean.MyBase3;
import Url.Url;
import static com.example.dell.myjrtt.R.id.f3_lv;


/**
 * Created by dell on 2017/3/22.
 * 关注 页面
 */


public class f3 extends Fragment {

    private TextView myguanzhu;
    private Button jia;
    private ImageView hayouimage;
    private TextView haoyou;
    private LinearLayout f3_111;
    private String s3;
    private ListView f3_lv1;
    public f3(String s3) {
        this.s3 = s3;
    }
    public f3() {

    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String ss= (String) msg.obj;
            Bean1 bean = new Gson().fromJson(ss, Bean1.class);
            List<Bean1.ResultBean.DataBean> data1 = bean.getResult().getData();
            //Toast.makeText(context,data1.toString(),Toast.LENGTH_SHORT).show();
            f3_lv1.setAdapter(new MyBase3(getActivity(),data1));
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f3, null);
        iniView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new HttpURLUtlis(Url.url+"kj",handler).start();
    }
    private void iniView(View v) {
        myguanzhu = (TextView) v.findViewById(R.id.f3_myguanzhu);
        jia = (Button) v.findViewById(R.id.f3_jia);
        hayouimage = (ImageView) v.findViewById(R.id.f3_haoyou_image);
        haoyou = (TextView) v.findViewById(R.id.haoyou);
        f3_111 = (LinearLayout) v.findViewById(R.id.f3_ll);
        f3_lv1 = (ListView) v.findViewById(f3_lv);

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity3tof3.class);
                startActivity(intent);
            }
        });
    }
}
