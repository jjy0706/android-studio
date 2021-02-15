package com.example.basketball;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper {

    public static final String COLUMN_num = "num";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_hei = "hei";
    public static final String COLUMN_ph = "ph";
    public static final String COLUMN_pos = "posi";
    public static final String COLUMN_skill = "skill";
    public static final String COLUMN_area = "area";
    public static final String COLUMN_age = "age";

    SQLiteDatabase database;

    Helper(Context context) {
        super(context, "U", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table UserInfo(id text primary key,pw text,name text ,ph text,posi text,hei text,skill text,age text,area text);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists UserInfo;");

        onCreate(sqLiteDatabase);

    }
   public boolean drop(){
           SQLiteDatabase database = this.getWritableDatabase();

           database.execSQL("drop table UserInfo");

           database.execSQL(
                   "create table UserInfo(id text primary key,pw text,name text ,ph text,posi text,hei text,skill text,age text,area text);"
           );

        return true;
    }

    public boolean insert(String id, String pw, String name, String ph){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id",id);
        values.put("pw",pw);
        values.put("name",name);
        values.put("ph",ph);

        long s = database.insert("UserInfo",null,values);

        if (s != -1){
            return true;
        }else {
            return false;
        }
    }
    public String loginidCheck(String id) {

        Log.d(getClass().getName(), "헬퍼로그인체크받는" + id);

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from UserInfo where id ='"+id+"'", null);
        String s = null;
        while (cursor.moveToNext()) {
            s = cursor.getString(cursor.getColumnIndex("id"));
            if (s.equals(id) == true) {
                s = id;
            } else {
                s = "";
            }
        }
        return s;
    }

    public boolean Mypageupdate(String id, String ph, String posi,String hei,String skill,String age,String name){

        Log.d(getClass().getName(), "헬퍼페이지수정받는" + id);

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("ph",ph);
        values.put("posi",posi);
        values.put("hei",hei);
        values.put("skill",skill);
        values.put("age",age);
        values.put("name",name);

        database.update("UserInfo",values,"id=?",new String []{id});

        return true;
    }

    public ArrayList Board(){

        ArrayList list = new ArrayList();

        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from UserInfo",null);

        cursor.moveToFirst();

        int i = 1;

            while (cursor.isAfterLast() == false) {

                    list.add(i+".\r\n"+"닉네임:"+cursor.getString(cursor.getColumnIndex(COLUMN_NAME))+"\r\n"+":포지션:"+cursor.getString(cursor.getColumnIndex(COLUMN_pos)) + "\r\n신장:" + cursor.getString(cursor.getColumnIndex(COLUMN_hei))
                            + "\r\n활동지역:" + cursor.getString(cursor.getColumnIndex(COLUMN_area)) + "\r\n나이:" + cursor.getString(cursor.getColumnIndex(COLUMN_age)));
                    i++;
                cursor.moveToNext();
            }
        return list;
    }

    public boolean BoardInfo(String id,String posi,String hei,String area,String age){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("posi",posi);
        values.put("hei",hei);
        values.put("area",area);
        values.put("age",age);

        database.update("UserInfo",values,"id=?",new String []{id});

        return true;
}

    public Cursor getData(String id,String name){

        Log.d(getClass().getName(),"헹퍼에서받는값"+id);

        Log.d(getClass().getName(),"헹퍼에서받는값"+name);

        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from UserInfo where id='"+id+"'",null);

        return cursor;
    }


    public Cursor getlistData(String name){

            SQLiteDatabase database = this.getReadableDatabase();

            Log.d(getClass().getName(),"헹퍼에서받는값"+name);

            Cursor cursor = database.rawQuery("select * from UserInfo where name = '"+name+"'",null);

            return cursor;
    }
}
