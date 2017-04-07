package MyOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 类的用途：数据库帮助类
 * 作者：高坚译
 * 时间： 2017/3/6 10:18
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "mytable.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table mytable(_id integer primary key autoincrement,item_id varchar,categoryTitle varchar,detectionItem varchar,url varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

//        //获取数据库帮助类
//        MyOpenHelper helper = new MyOpenHelper(getActivity());
//        db = helper.getWritableDatabase();
//        for (int i = 0; i < plist.size(); i++) {
//            db.execSQL("insert into mytable(item_id,categoryTitle,detectionItem,url) values(?,?,?,?)",new Object[]{plist.get(i).getImgpath(),plist.get(i).getPtitle(),plist.get(i).getPteamId()+"",plist.get(i).getPteamprice()+""});
//        }
//        Toast.makeText(getActivity(), "添加数据库成功", Toast.LENGTH_SHORT).show();

    }
}
