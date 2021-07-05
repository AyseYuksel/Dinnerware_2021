package com.example.dinnerware;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class veritabani extends SQLiteOpenHelper {

    public veritabani(@Nullable Context context) {
        super(context, "dinnerware_db",null ,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table uyeler(uyeid integer primary key,ad text,soyad text,kulad text,sifre text)");
        db.execSQL("create table yorumlar(kulid integer primary key,kulad text,yorum text,puan text)");
        db.execSQL("create table siparisler(musid integer primary key,kulad text,siparis text,tutar text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists uyeler");
        db.execSQL("drop table if exists yorumlar");
        db.execSQL("drop table if exists siparisler");
        this.onCreate(db);
    }

    void ekle(String ad,String soyad,String kulad,String sifre){
        SQLiteDatabase vt=this.getWritableDatabase();
        vt.execSQL("insert into uyeler(ad,soyad,kulad,sifre) values('"+ad+"','"+soyad+"','"+kulad+"','"+sifre+"')");
        vt.close();
    }

    public Boolean checkusernamepassword(String kuladi,String sifresi){
        SQLiteDatabase vt=this.getWritableDatabase();
        Cursor cursor=vt.rawQuery("select * from uyeler where kulad = ? and sifre = ?",new String[]{kuladi,sifresi});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }

   public Cursor getListContents(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from uyeler",null);
        return data;
   }


    void yorumekle(String kuladi,String yorum,String puan){
        SQLiteDatabase vt=this.getWritableDatabase();
        vt.execSQL("insert into yorumlar(kulad,yorum,puan) values('"+kuladi+"','"+yorum+"','"+puan+"') ");
        vt.close();
    }
    public Cursor getComents(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from yorumlar",null);
        return data;
    }



    void siparisekle(String kulad,String siparis,String tutar){
            SQLiteDatabase vt=this.getWritableDatabase();
            vt.execSQL("insert into siparisler(kulad,siparis,tutar) values('"+kulad+"','"+siparis+"','"+tutar+"')");
            vt.close();
    }

    public Cursor getSiparisler(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from siparisler",null);
        return data;
    }
}
