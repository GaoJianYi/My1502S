package Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dell.myjrtt.MainActivityF4_SC;
import com.example.dell.myjrtt.MainActivityQQ;
import com.example.dell.myjrtt.MainActivity_TuiChuDL;
import com.example.dell.myjrtt.MainActivitydDenL;
import com.example.dell.myjrtt.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import MyBean.MyBaseSSS;
import Utils.UiUtils;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by dell on 2017/3/22.
 */
public class fragment4 extends Fragment implements View.OnClickListener{
    private ImageView iv1,iv2,iv3;
    private ImageView iv4;
    private RadioButton bt1,bt2,bt3;
    private ListView lv;
    private List<View> ll=new ArrayList<>();
    private List<String> list=new ArrayList<>();
    private LinearLayout ll1;
    private TextView t1;
    private boolean zt1;
    public static final int NONE = 0;
    public static final int PHOTO_CAMERA = 1;// 相机拍照
    public static final int PHOTO_COMPILE = 2; // 编辑图片
    public static final int PHOTO_RESOULT = 3;// 结果
    private String ImageName;
    private boolean qq1;
    private SharedPreferences qq;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f4, null);
        initView(v);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void initView(View v) {
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(getActivity()));
        ll1 = (LinearLayout) v.findViewById(R.id.f4_ll);
        list.add("消息通知");list.add("活动");list.add("头条商城");
        list.add("东京特卖");list.add("我要爆料");list.add("用户反馈");
        lv= (ListView) v.findViewById(R.id.f4_lv);
        iv1= (ImageView) v.findViewById(R.id.f4_shouji);
        iv2= (ImageView) v.findViewById(R.id.f4_qq);
        registerForContextMenu(iv2);
        iv3= (ImageView) v.findViewById(R.id.f4_xinglang);
        iv4= (ImageView) v.findViewById(R.id.f4_image_image);
        bt1= (RadioButton) v.findViewById(R.id.f4_button1);
        bt2= (RadioButton) v.findViewById(R.id.f4_button2);
        bt3= (RadioButton) v.findViewById(R.id.f4_button3);
        ll.add(iv1);ll.add(iv2);ll.add(iv3);ll.add(iv4);
        ll.add(bt1);ll.add(bt2);ll.add(bt3);
        t1= (TextView) v.findViewById(R.id.f4_textet_text_1);
        SharedPreferences zt = getActivity().getSharedPreferences("ZT", MODE_PRIVATE);
        zt1 = zt.getBoolean("zt", false);
        qq = getActivity().getSharedPreferences("QQ", MODE_PRIVATE);
        qq1 = qq.getBoolean("状态", false);
        if (qq1==true){
            Toast.makeText(getActivity(),"QQ已授权登录",Toast.LENGTH_SHORT).show();
            String touxiang = qq.getString("头像", null);
            String nc = qq.getString("昵称", null);
            t1.setText(nc);
            iv1.setVisibility(View.INVISIBLE);
            iv3.setVisibility(View.INVISIBLE);
            ImageLoader.getInstance().displayImage(touxiang,iv2);
        }else if (zt1 ==true){
            String sj = zt.getString("sj", null);
            t1.setText(sj);
            Toast.makeText(getActivity(),"已登录",Toast.LENGTH_SHORT).show();
            iv1.setVisibility(View.INVISIBLE);
            iv3.setVisibility(View.INVISIBLE);

        }else if (zt1 ==false){
//            t1.setText("登录推荐更精准");
            iv1.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < ll.size(); i++) {
            ll.get(i).setOnClickListener(this);
        }
        lv.setAdapter(new MyBaseSSS(getActivity(),list));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f4_shouji:
                Intent intent = new Intent(getActivity(), MainActivitydDenL.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.f4_qq:
                if (zt1==true){
                    Toast.makeText(getActivity(),"66666666",Toast.LENGTH_SHORT).show();
                    registerForContextMenu(iv2);
                }else if(qq1==false){
                Intent intentqq=new Intent(getActivity(), MainActivityQQ.class);
                startActivity(intentqq);
                getActivity().finish();}
                break;
            case R.id.f4_textet_text_1:

                break;
            case R.id.f4_xinglang:
                break;
            case R.id.f4_image_image:
                break;
            case R.id.f4_button1:
                Intent intentw=new Intent(getActivity(), MainActivityF4_SC.class);
                startActivity(intentw);
//                getActivity().finish();
                break;
            case R.id.f4_button2://白天黑夜
                UiUtils.switchAppTheme(getActivity());
                reload();
                break;
            case R.id.f4_button3:
                if (zt1==true||qq1==true){
                    Intent intent1 = new Intent(getActivity(), MainActivity_TuiChuDL.class);
                    startActivity(intent1);
                }

                break;

        }
    }
    public static String getStringToday() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (zt1==true||qq1==true){
            menu.setHeaderTitle("请选择你的操作");
            menu.add(0,0, Menu.NONE,"拍照");
            menu.add(0,1, Menu.NONE,"选择图片");
            menu.add(0,2, Menu.NONE,"取消");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case 0:
                //设置图片的名称
                ImageName = "/" + getStringToday() + ".png";
                // 设置调用系统摄像头的意图(隐式意图)
                Intent intent22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //设置照片的输出路径和文件名
                File file=    new File(Environment.getExternalStorageDirectory(), ImageName);
                intent22.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                //开启摄像头
                startActivityForResult(intent22, PHOTO_CAMERA);
                break;
            case 1:
                // 设置调用系统相册的意图(隐式意图)
                Intent intent11 = new Intent();
                //设置值活动//android.intent.action.PICK
                intent11.setAction(Intent.ACTION_PICK);
                //设置类型和数据
                intent11.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                // 开启系统的相册
                startActivityForResult(intent11, PHOTO_COMPILE);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return  true;
    }
    // 调用startActivityResult，返回之后的回调函数
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == NONE)
            return;
        // 通过照相机拍照的图片出理
        if (requestCode == PHOTO_CAMERA) {
            // 设置文件保存路径这里放在跟目录下
            File picture = new File(Environment.getExternalStorageDirectory()
                    + ImageName);
            //裁剪图片
            startPhotoZoom(Uri.fromFile(picture));
        }
        if (data == null)
            return;
        // 读取相册裁剪图片
        if (requestCode == PHOTO_COMPILE) {
            //裁剪图片
            startPhotoZoom(data.getData());
        }
        // 裁剪照片的处理结果
        if (requestCode == PHOTO_RESOULT) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0 -
                // 100)压缩文件
                //设置图片显示内容
                iv2.setImageBitmap(photo);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //裁剪
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 64);
        intent.putExtra("outputY", 64);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_RESOULT);
    }
    public void reload() {
        Intent intent = getActivity().getIntent();
        getActivity().overridePendingTransition(R.anim.activity_in, R.anim.activity_out);//进入动画
        getActivity().finish();
        getActivity().overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        startActivity(intent);
    }
}
