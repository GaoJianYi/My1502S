package HttpUrlDoGet;
import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by dell on 2017/3/20.
 */

public class HttpURLUtlis extends Thread{
    String urls;
    Handler handler;
    String resurl="";

    public HttpURLUtlis(String urls, Handler handler) {
        this.urls = urls;
        this.handler = handler;
    }
    @Override
    public void run() {
        super.run();
        String doget = Doget();
        Message message = new Message();
        message.what = 0;
        message.obj = doget;
        handler.sendMessage(message);
    }
    public String Doget() {
        HttpURLConnection connection = null;
        URL url = null;
        try {
            url = new URL(urls);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //链接延迟
            connection.setConnectTimeout(5000);
            //读取延迟
            connection.setReadTimeout(5000);
            //获取网址请求码
            int res=connection.getResponseCode();
            if (res == 200) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                byte[] by = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(by)) != -1) {
                    bao.write(by, 0, len);
                }
                resurl = bao.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                connection.disconnect();//释放资源
            }
        }
        return resurl;
    }}
