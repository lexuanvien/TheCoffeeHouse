package com.example.thecoffeehouse.gridviewadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHander extends SQLiteOpenHelper {
    private static final String TAG = SQLiteHander.class.getSimpleName();
    public static final String DATABASE_NAME = "qlapp.db";
    public static final Integer DATABASE_VERSION = 1;

    public static final String TABLE_INFO ="Info";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_BRITHDAY = "brithday";
    public SQLiteHander(Context context) {
        super(context,DATABASE_NAME ,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sinhvien = "CREATE TABLE " +TABLE_INFO +"(" +
                KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME +" TEXT," +
                KEY_EMAIL +" TEXT," +
                KEY_BRITHDAY +" TEXT" +
                ")";
        String them = "INSERT INTO "+TABLE_INFO +" ("+KEY_ID+", "+KEY_NAME+","+KEY_EMAIL+","+KEY_BRITHDAY+") VALUES" +
                "(1, 'Vien', 'vienhelios@gmail.com','08/12/2018')," +
                "(2, 'le', 'levien@gmail.com','08/12/2018');";
        sqLiteDatabase.execSQL(sinhvien);
        sqLiteDatabase.execSQL(them);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TABLE_INFO);
    }
    //lấy dữ liệu bảng danh sách
    public Cursor getAllDataSV(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_INFO, null);
        return cursor;
    }
    public void themsv(String id, String name,String sex,String job,String birthday){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, job);
        values.put(KEY_BRITHDAY, birthday);
        long ma = db.insert(TABLE_INFO, null, values);
        db.close(); // Closing database connection
        Log.d(TAG, "Thêm mới thành công " + ma);
    }
    public void delete(String ma){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM " + TABLE_INFO +" WHERE ma='%s' ",ma);
        db.execSQL(query);
    }
    //cập nhật dữ liệu bảng
    public void updateDataList(String ma,String id,String name,String sex,String job,String birthday){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, sex);
        values.put(KEY_BRITHDAY, birthday);
        long result = db.update(TABLE_INFO, values, KEY_ID + "=?", new String[]{ma});
        db.close(); // Closing database connection
        Log.d(TAG, "Cập nhật thành công " + result);
    }

}
