package Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * date:2017/4/21
 * author:高坚译（dell）
 * Time:18:45
 */
public class Preferences {
    private static final String shared_name="user_guide";

    public static String getString(Context context, String key,
                                   String defaultValues) {
        SharedPreferences sp = context.getSharedPreferences(shared_name,
                context.MODE_PRIVATE);
        return sp.getString(key, defaultValues);
    }

    public static void setString(Context context, String key, String Values) {
        SharedPreferences sp = context.getSharedPreferences(shared_name,
                context.MODE_PRIVATE);
        sp.edit().putString(key, Values).commit();
    }
}