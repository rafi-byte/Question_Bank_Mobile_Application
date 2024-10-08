package com.example.questionbankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class authDbhelper  extends SQLiteOpenHelper {
    public static final String DBname="questionLogin.db";

    public authDbhelper( Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase logDb) {
        logDb.execSQL("create table users(username TEXT primary key, password TEXT)");
        logDb.execSQL("CREATE TABLE payments (userid TEXT, contentid TEXT, isPaid INTEGER)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase logDb, int oldVersion, int newVersion) {
        logDb.execSQL("DROP TABLE IF EXISTS users");
//        onCreate(logDb);
    }

    public Boolean insertData(String username,String password){
        SQLiteDatabase logDb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=logDb.insert("users",null,contentValues);
        if(result==-1) return false;
        else return true;

    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkPassword(String username, String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username = ? and password =?", new String[] {username, password});
        if(cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }


}
