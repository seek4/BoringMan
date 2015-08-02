package me.yangtong.boringman.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.yangtong.boringman.model.TimeInfo;

/**
 * Created by yangtong on 2015/7/2.
 */
public class TimeOperate {
    //数据库名称
    private static String DB_NAME = "time.db";
    //
    private static int DB_VERSION = 2;
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public TimeOperate(Context context){
        dbHelper = new DatabaseHelper(context,DB_NAME,null,DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
        dbHelper.close();
    }

    /**
     * 得到所有的TimeInfo
     * @return
     */
    public List<TimeInfo> getAllTimeInfo(){
        List<TimeInfo> timeInfos = new ArrayList<TimeInfo>();
        Cursor cursor = db.query(DatabaseHelper.TB_NAME,null,null,null,null,
                null,TimeInfo.ID+" DESC");
        if(cursor==null||cursor.getCount()<=0) {
            Log.e("yangtong", "cursor is null!");
            return null;
        }
        cursor.moveToFirst();
        TimeInfo timeInfo;
        while (!cursor.isAfterLast()){
            timeInfo = new TimeInfo();
            timeInfo.id = cursor.getInt(0);
            timeInfo.startTime = cursor.getLong(1);
            timeInfo.endTime = cursor.getLong(2);
            timeInfo.appInfo = cursor.getString(3);
            timeInfo.type = cursor.getInt(4);
            timeInfos.add(timeInfo);
            cursor.moveToNext();
        }
        return timeInfos;
    }

    public void insertTimeInfo(TimeInfo timeInfo){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TimeInfo.START_TIME,timeInfo.startTime);
        contentValues.put(TimeInfo.END_TIME,timeInfo.endTime);
        contentValues.put(TimeInfo.APP_INFO, timeInfo.appInfo);
        contentValues.put(TimeInfo.TYPE,timeInfo.type);
        db.insert(DatabaseHelper.TB_NAME,null,contentValues);
    }

    public void deleteById(int id){
        db.delete(DatabaseHelper.TB_NAME,TimeInfo.ID+"=?",new String[]{""+id});
    }

}
