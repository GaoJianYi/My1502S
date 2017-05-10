package Utils;

import android.widget.ImageView;


import com.example.dell.myjrtt.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;


/**
 * Created by Administrator on 2017/4/20.
 * time:
 * author:付智焱
 */

public class MyImage {
    public void show(String url, ImageView iv){
        x.image().bind(iv,url,new ImageOptions.Builder().setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120)).setRadius(DensityUtil.dip2px(5)).setFailureDrawableId(R.mipmap.ic_launcher).setLoadingDrawableId(R.mipmap.ic_launcher).build());
    }

}
