package me.yangtong.boringman.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.yangtong.boringman.model.TimeInfo;

/**
 * Created by yangtong on 2015/7/2.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TB_NAME = "boring_time";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建表格
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                        TB_NAME + "(" +
                        TimeInfo.ID + " integer primary key," +
                        TimeInfo.START_TIME + " bigint," +
                        TimeInfo.END_TIME + " bigint," +
                        TimeInfo.APP_INFO + " varchar," +
                        TimeInfo.TYPE + " integer" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }
}
