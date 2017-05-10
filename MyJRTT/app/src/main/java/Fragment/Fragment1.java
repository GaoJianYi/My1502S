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
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.dell.myjrtt.MainActivityWeb;
import com.example.dell.myjrtt.R;
import com.google.gson.Gson;
import java.util.List;
import MyBean.Bean1;
import MyBean.MyBase1;
import Utils.MyXUtils1;
import Utils.My_FX;

/**
 * Created by Administrator on 2017/4/20.
 * time:
 * author:付智焱
 */

public class Fragment1 extends Fragment {
    public Fragment1() {
    }

    private String url;

    public Fragment1(String url, String sansu) {
        this.url = url;
        this.sansu = sansu;
    }
    private List<Bean1.ResultBean.DataBean> data1;
    private String sansu;
    private ListView listView;
    private Handler han = new Handler(){



        @Override
        public void handleMessage(Message msg) {

            if(msg.what==1){
                String ss= (String) msg.obj;
                Bean1 bean = new Gson().fromJson(ss, Bean1.class);
                data1 = bean.getResult().getData();
                listView.setAdapter(new MyBase1(getActivity(), data1));
            }
        }

    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        listView = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new MyXUtils1(han,url,sansu).Get();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = data1.get(position).getUrl();
                Intent intent=new Intent(getActivity(), MainActivityWeb.class);
                intent.putExtra("Url", url);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String url = data1.get(position-1).getUrl();
                String baty = data1.get(position - 1).getTitle();
                String bt2 = data1.get(position - 1).getAuthor_name();
                String url2 = data1.get(position - 1).getThumbnail_pic_s02();
                new My_FX(getActivity(),baty,url,bt2,url2).fenXiang();
                return false;
            }
        });
    }
}


