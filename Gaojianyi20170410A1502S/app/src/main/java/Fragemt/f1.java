package Fragemt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.gaojianyi20170410a1502s.MyHttp;
import com.example.dell.gaojianyi20170410a1502s.R;

/**
 * date:2017/4/10
 * author:高坚译（dell）
 * Time:8:58
 */

public class f1 extends Fragment {
    private String s;
    private ListView lv;
    public f1(String s) {
        this.s = s;
    }
//private Handler handler=new Handler(){
//    @Override
//    public void handleMessage(Message msg) {
//        super.handleMessage(msg);
//        String ss= (String) msg.obj;
//        Bean bean = new Gson().fromJson(ss, Bean.class);
//        List<Bean.ResultBean> result = bean.getResult();
//        lv.setAdapter(new MyBase(getActivity(),result));
//    }
//};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f1, null);
        lv= (ListView) v.findViewById(R.id.lv);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        new HttpURLUtlis(s,handler).start();
        MyHttp myHttp = new MyHttp(getActivity(),s,lv);
        myHttp.Get();
    }
}
