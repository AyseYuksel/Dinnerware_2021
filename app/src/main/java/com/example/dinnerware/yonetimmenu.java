package com.example.dinnerware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class yonetimmenu extends AppCompatActivity {
    Button musteribilgi,siparisbilgi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yonetimmenu);

        musteribilgi=(Button)findViewById(R.id.musteribilgi);
        siparisbilgi=(Button)findViewById(R.id.siparisbilgi);

        musteribilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),musteriliste.class);
            startActivity(intent);
            }
        });

        siparisbilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),siparislistesi.class);
                startActivity(intent2);
            }
        });


    }
}
