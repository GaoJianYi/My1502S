package Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date:2017/4/24
 * author:高坚译（dell）
 * Time:9:21
 */
public class NetWorkUtile {
    public static boolean isWifi(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null && info.getType() == manager.TYPE_WIFI){
            return true;
        }
        return false;
    }
}
