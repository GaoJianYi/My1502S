package JsonUtile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类的用途：
 * 作者：dell
 * 时间： 2017/3/6 09:19
 */

public class JsonUtile {

    //解析json串数据
    public static String getData(InputStream is){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        try {
            while ((len = is.read(b))!=-1){
                os.write(b,0,len);
            }
            is.close();
            os.close();
            return os.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
