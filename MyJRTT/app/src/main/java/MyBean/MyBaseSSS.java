package MyBean;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.myjrtt.MainActivityShangChen;
import com.example.dell.myjrtt.MainActivity_CSLB;
import com.example.dell.myjrtt.R;

import java.util.List;

/**
 * date:2017/4/12
 * author:高坚译（dell）
 * Time:19:49
 */

public class MyBaseSSS extends BaseAdapter {
    Context context;
    List<String> list;

    public MyBaseSSS(Context context, List<String> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHoder v;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.f4_list,null);
            v=new ViewHoder();
            v.t1= (TextView) convertView.findViewById(R.id.f4_list_t1);
            convertView.setTag(v);
        }else {
            v= (ViewHoder) convertView.getTag();
        }
        v.t1.setText(list.get(position));
        v.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).equals("头条商城")){
                    Intent intent=new Intent(context, MainActivityShangChen.class);
                    context.startActivity(intent);
                }else if (list.get(position).equals("东京特卖")){
                   Intent intent=new Intent(context, MainActivity_CSLB.class);
                    context.startActivity(intent);
                }

                else {
                Toast.makeText(context,"还没有操作",Toast.LENGTH_LONG).show();
            }}
        });

        return convertView;
    }
    class ViewHoder{
        TextView t1;
    }
}
