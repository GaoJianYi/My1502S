package Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.dell.myjrtt.GridActivity;
import com.example.dell.myjrtt.R;
import com.google.gson.Gson;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;
import java.util.ArrayList;
import java.util.List;
import MyBean.MypagerAdapter;
import MyBean.TitleBean;
import Url.Url;
import Utils.MyHelper;
import Utils.MyUrlConnection;
public class f1 extends Fragment{
    private ImageView image;
    private SQLiteDatabase db;
    private SharedPreferences preferences;
    private boolean flag;
    private MagicIndicator mg;
    private List<String> list;
    private CommonNavigator commonNavigator;
    private SharedPreferences.Editor edit;
    private List<String> ulist;
    private ViewPager vp;
    private List<Fragment> frag=new ArrayList<>();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json = (String) msg.obj;
            Gson gson = new Gson();
            TitleBean titleBean = gson.fromJson(json, TitleBean.class);
            List<TitleBean.ResultBean.DateBean> date = titleBean.getResult().getDate();
            ArrayList<String> titles = new ArrayList<>();
            MyHelper mySQLlite = new MyHelper(getActivity());
            db = mySQLlite.getReadableDatabase();
            flag = preferences.getBoolean("flag",true);
            if (flag) {
                for (int i = 0; i < date.size(); i++) {
                    ContentValues values = new ContentValues();
                    if (i % 2 == 0) {
                        values.put("name", date.get(i).getTitle());
                        values.put("url", date.get(i).getUri());
                        values.put("style", "1");
                        long id = db.insert("channel", null, values);
                    }
                    if (i % 2 == 1) {
                        values.put("name", date.get(i).getTitle());
                        values.put("url", date.get(i).getUri());
                        values.put("style", "0");
                        db.insert("channel", null, values);
                    }
                    titles.add(date.get(i).getTitle());
                }
                edit.putBoolean("flag",false);
                edit.commit();
            }
            list = new ArrayList<>();
            Cursor cursor = db.query("channel", new String[]{"name"}, "style=?", new String[]{"1"}, null, null, null);
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                list.add(string);
            }
            ulist=new ArrayList<>();
            Cursor cursors = db.query("channel", new String[]{"url"}, "style=?", new String[]{"1"}, null, null, null);
            while (cursors.moveToNext()) {
                String str = cursors.getString(0);
                ulist.add(str);
            }
            for (int i = 0; i < ulist.size(); i++){
                frag.add(new Fragment1(Url.path,ulist.get(i).toString()));
            }
            commonNavigator = new CommonNavigator(getActivity());
            commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                private ClipPagerTitleView clipagertitle;
                @Override
                public int getCount() {
                    return list.size();
                }
                @Override
                public IPagerTitleView getTitleView(Context context, final int index) {
                    clipagertitle = new ClipPagerTitleView(context);
                    clipagertitle.setTextSize(30);
                    clipagertitle.setText(list.get(index));
                    clipagertitle.setTextColor(Color.BLACK);
                    clipagertitle.setClipColor(Color.RED);
                    clipagertitle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                    vp.setCurrentItem(index);
                        }
                    });
                    return clipagertitle;
                }
                @Override
                public IPagerIndicator getIndicator(Context context) {
                    LinePagerIndicator indictor=new LinePagerIndicator(getActivity());
                    indictor.setColors(Color.RED);
                    return indictor;
                }
            });
            MypagerAdapter my = new MypagerAdapter(getActivity().getSupportFragmentManager(),frag);
            vp.setAdapter(my);
            vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    mg.onPageScrolled(position,positionOffset,positionOffsetPixels);
                }
                @Override
                public void onPageSelected(int position) {
                    mg.onPageSelected(position);
                }
                @Override
                public void onPageScrollStateChanged(int state) {
                    mg.onPageScrollStateChanged(state);
                }
            });
            mg.setNavigator(commonNavigator);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f1_f1,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        preferences = getActivity().getSharedPreferences("style_flag", Context.MODE_PRIVATE);
        edit = preferences.edit();
        new MyUrlConnection(handler, Url.uurl).start();
    }
    private void initView(View view) {

        vp= (ViewPager) view.findViewById(R.id.vp);
        mg= (MagicIndicator) view.findViewById(R.id.mag);
        image= (ImageView) view.findViewById(R.id.imgplus);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(),GridActivity.class);
                startActivity(in);
            }
        });
    }
}
