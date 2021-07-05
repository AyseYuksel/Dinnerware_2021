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

public class kullaniciyorumlari extends AppCompatActivity {

    veritabani vt;
    Context c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullaniciyorumlari);

        c=this;
        vt = new veritabani(this);

        ListView yorumlarlistesi=(ListView)findViewById(R.id.yorumlarliste);

        ArrayList<String> theList=new ArrayList<>();
        Cursor data=vt.getComents();

        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"Veri tabanı boş",Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                theList.add("Kullanıcı adı : "+data.getString(1)+"\n"+data.getString(2)+"\n Puan : "+data.getString(3));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                yorumlarlistesi.setAdapter(listAdapter);
            }
        }

    }

}
