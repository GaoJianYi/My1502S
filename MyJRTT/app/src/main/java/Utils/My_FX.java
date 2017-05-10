package Utils;

import android.content.Context;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * date:2017/4/21
 * author:高坚译（dell）
 * Time:10:28
 */

public class My_FX {
    Context context;
    private String baty;//标题
    private String url;//地址
    private String bt2;//网址名称
    private String url2;//图片地址

    public My_FX(Context context, String baty, String url, String bt2, String url2) {
        this.context = context;
        this.baty = baty;
        this.url = url;
        this.bt2 = bt2;
        this.url2 = url2;
    }

    public void fenXiang(){
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(baty);
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(bt2);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(url2);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(baty);
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(url);

// 启动分享GUI
        oks.show(context);
    }
}
