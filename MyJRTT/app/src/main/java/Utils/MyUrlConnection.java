package Utils;

import android.os.Handler;
import android.os.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/4/20.
 * time:
 * author:付智焱
 */

public class MyUrlConnection extends Thread{
    public MyUrlConnection(Handler handler, String url) {
        this.handler = handler;
        this.url = url;


    }


    @Override

    public void run() {
        String result=getString();
        if (result!=null){
            Message msg= Message.obtain();
            msg.what=2;
            msg.obj=result;
            handler.sendMessage(msg);
        }
    }
    private Handler handler;
    private String url;
    private String getString(){
        HttpURLConnection urlConnection=null;
        ByteArrayOutputStream bos=null;
        InputStream is=null;
        try {
            URL murl=new URL(url);
            urlConnection= (HttpURLConnection) murl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            if (urlConnection.getResponseCode()==200){
                is=urlConnection.getInputStream();
                int hasRead=-1;
                byte [] bytes=new byte[1240];
                bos=new ByteArrayOutputStream();
                while ((hasRead=is.read(bytes))!=-1){
                    bos.write(bytes,0,hasRead);
                }
                return bos.toString();


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {  if (bos!=null){
                bos.close();
            }
                if (is!=null){
                    is.close();
                }
                if (urlConnection!=null){
                    urlConnection.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();}

        }

        return  null;
    }

}


