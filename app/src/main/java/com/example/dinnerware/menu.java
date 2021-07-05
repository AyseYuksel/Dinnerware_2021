package com.example.dinnerware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {

    Button yorumlar,icerik,suprizsecim,siparisver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        yorumlar=(Button)findViewById(R.id.yorumlar);
        icerik=(Button)findViewById(R.id.icerik);
        suprizsecim=(Button)findViewById(R.id.suprizsecim);
        siparisver=(Button)findViewById(R.id.siparisver);

        Bundle bundle=getIntent().getExtras();
        String kuladi=bundle.getString("kuladi");

        siparisver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent1=new Intent(getApplicationContext(),siparisver.class);
            intent1.putExtra("kuladi",kuladi);
            startActivity(intent1);
            }
        });

        icerik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent2=new Intent(getApplicationContext(),icerik.class);
            startActivity(intent2);
            }
        });

        suprizsecim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent3=new Intent(getApplicationContext(),suprizsecim.class);
            startActivity(intent3);
            }
        });

        yorumlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getApplicationContext(),yorum.class);
                intent4.putExtra("kuladi",kuladi);
                startActivity(intent4);

            }
        });


    }


}

