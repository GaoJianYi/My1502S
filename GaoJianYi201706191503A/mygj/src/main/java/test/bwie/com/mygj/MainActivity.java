package test.bwie.com.mygj;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import static test.bwie.com.mygj.R.id.textView_count;

public class MainActivity extends AppCompatActivity {
    private ExpandView mExpandView;
    private RelativeLayout mLinearLayout, rl,My_template,My_relativeLayout;
    private TextView tv1,countText,textView_dian;
    private TagFlowLayout mFlowLayout;
    private EditText editText;
    private Button button;
    private LinearLayout activity_main;
    List<String> mExpandViewlist=new ArrayList<>();
    private List<String> strings;
    //布局管理器
    private LayoutInflater mInflater;
    //流式布局的子布局
    private TextView tv;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    adapter = new TagAdapter<String>(strings) {
                        @Override
                        public View getView(FlowLayout parent, int position, String s) {
                            tv = (TextView) mInflater.inflate(R.layout.tv,
                                    mFlowLayout, false);
                            if (s.equals("联系人")) {
                                tv.setTextColor(Color.RED);
                                tv.setBackgroundColor(Color.WHITE);
                            }
                            tv.setText(s);
                            return tv;
                        }
                    };
                    mFlowLayout.setAdapter(adapter);
                    break;
                case 2:
                    adapter = new TagAdapter<String>(strings) {
                        @Override
                        public View getView(FlowLayout parent, int position, String s) {
                            tv = (TextView) mInflater.inflate(R.layout.tv,
                                    mFlowLayout, false);
                            if (s.equals("联系人")) {
                                tv.setTextColor(Color.RED);
                                tv.setBackgroundColor(Color.WHITE);
                            }
                            tv.setText(s);
                            return tv;
                        }
                    };
                    mFlowLayout.setAdapter(adapter);
                    int i = strings.size() - 1;
                    tv1.setText("共计"+i+"人");
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private TagAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initExpandView();
        mExpandView.setCallS(new CallStringList() {
            @Override
            public void calllist(List<String> list) {
                if (list.size()<4){
                    textView_dian.setVisibility(View.GONE);
                }
                if (list!=null){
                    strings = list;
                    handler.sendEmptyMessageDelayed(2, 0);
                }

            }
        });
    }
    private void initData() {
        mInflater = LayoutInflater.from(this);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        strings = new ArrayList<>();
        strings.add("联系人");
            for (int i = 0; i < 20; i++) {
                if (i%2==0){
                    strings.add("AA");
                }else {
                    strings.add("BBB");
                }
        }
            handler.sendEmptyMessageDelayed(1, 0);
        //流式布局tag的点击方法
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                if (!strings.get(position).toString().equals("联系人")) {
//                    Toast.makeText(MainActivity.this, strings.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    if (mExpandView.isExpand()) {
                        mExpandView.collapse();
                        mLinearLayout.setVisibility(View.INVISIBLE);
                    }
                }
                return true;
            }
        });

    }


    public void initExpandView() {
        activity_main= (LinearLayout) findViewById(R.id.activity_main);

        countText= (TextView) findViewById(R.id.countText);
        editText= (EditText) findViewById(R.id.et_input);
//记录editText输入了多少  实时刷新
        editText.addTextChangedListener(new TextWatcher() {
            private int myselectionStart;
            private int myselectionEnd;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                int mynumber = s.length();
//                tvQuestionNumber.setText(number+"");
                countText.setText(mynumber+"/350");
                myselectionStart = editText.getSelectionStart();
                myselectionEnd = editText.getSelectionEnd();
                //删除多余输入的字（不会显示出来）
                if (mynumber > 350) {
                    s.delete(myselectionStart - 1, myselectionEnd);
                    editText.setText(s);
                    Toast.makeText(MainActivity.this, "到底了呦！！最多可以输入350个字",Toast.LENGTH_SHORT).show();
                }
                //设置光标在最后
                editText.setSelection(s.length());
            }
        });



       //判断集合如果小于2让”点”的Text View隐藏
        textView_dian= (TextView) findViewById(R.id.text_dian);
        if (strings.size()<4){
            textView_dian.setVisibility(View.GONE);
        }
        My_template= (RelativeLayout) findViewById(R.id.My_template);
        My_relativeLayout= (RelativeLayout) findViewById(R.id.My_relativeLayout);
        mLinearLayout = (RelativeLayout) findViewById(R.id.layout_title);
        mExpandView = (ExpandView) findViewById(R.id.expandView);
        tv1= (TextView) findViewById(textView_count);
        rl = (RelativeLayout) findViewById(R.id.rl);
        My_relativeLayout.setVisibility(View.GONE);
        int i = strings.size() - 1;
        tv1.setText("共计"+i+"人");
        mExpandViewlist = mExpandView.setContentView(mExpandView, mLinearLayout, My_template, My_relativeLayout);
//        if (strings!=mExpandViewlist){
//            strings=mExpandViewlist;
//
//            handler.sendEmptyMessage(2);
//        }

        mLinearLayout.setClickable(true);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //隐藏布局打开里一个
                mLinearLayout.setVisibility(View.GONE);
                My_template.setVisibility(View.VISIBLE);
                My_relativeLayout.setVisibility(View.VISIBLE);
//                if (mExpandView.isExpand()) {
//                    mExpandView.collapse();
//                }else {
                    mExpandView.expand();
//                }
            }
        });
    }





}
