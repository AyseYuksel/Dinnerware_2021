package com.example.dinnerware;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class musteriliste extends AppCompatActivity {
    veritabani vt;
    Context c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musteriliste);

        c=this;
        vt = new veritabani(this);

        ListView musteriliste=(ListView)findViewById(R.id.musterilistesi);

        ArrayList<String> theList=new ArrayList<>();
        Cursor data=vt.getListContents();

        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"Veri tabanı boş",Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                theList.add("Kullanıcı adı : "+data.getString(3)+"\n Şifre : "+data.getString(4));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                musteriliste.setAdapter(listAdapter);
            }
        }

    }



}
