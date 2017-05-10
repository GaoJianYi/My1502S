package Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017/4/15.
 * time:
 * author:付智焱
 */

    public class MyHelper extends SQLiteOpenHelper{
    public MyHelper(Context context ) {
        super(context, "mytest.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table channel(_id integer primary key autoincrement ,name  text unique ,url  text  ,style  text )";
        db.execSQL(sql);
        Log.i("TAG","创建数据库");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
