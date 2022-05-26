package net.micode.notes.ui;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "notepad.db";
    public final static int VERSION = 1;
    private static DbHelper instance = null;
    private SQLiteDatabase db;
    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context);
        }
        return instance;
    }

    private void openDatabase() {
        if (db == null) {
            db = getWritableDatabase();
        }
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table notepad(id INTEGER PRIMARY KEY AUTOINCREMENT, content varchar(300) not null, time varchar(30) not null default '')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /** 添加一条数据 */
    public long saveLamp(Enc_Notepadinfo pro) {
        openDatabase();
        ContentValues value = new ContentValues();
        value.put("content", pro.getContent());
        value.put("time", pro.getTime());
       return db.insert("notepad", null, value);
    }

    /** 更新一条数据 */
    public long updataItem(Enc_Notepadinfo pro) {
        openDatabase();
        ContentValues value = new ContentValues();
        value.put("content", pro.getContent());
        value.put("time", pro.getTime());
        return db.update("notepad",value,"id=?", new String[]{pro.getId()});


    }
    /** 查询所有数据 */
    public ArrayList<HashMap<String, Object>> getLampList() {
        openDatabase();
        Cursor cursor = db.query("notepad", null, null, null, null, null, null);
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        while (cursor.moveToNext()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("content", cursor.getString(cursor.getColumnIndex("content")));
            map.put("time", cursor.getString(cursor.getColumnIndex("time")));
            map.put("id", cursor.getString(cursor.getColumnIndex("id")));
            list.add(map);
        }
        return list;
    }

    /** 删除一条数据 */
    public long deletItem(String id) {
        openDatabase();
        return  db.delete("notepad","id=?", new String[]{id});
    }
    /** 查询有多少条记录 */
    public int getLampCount() {
        openDatabase();
        Cursor cursor = db.query("notepad", null, null, null, null, null, null);
        return cursor.getCount();
    }
}
