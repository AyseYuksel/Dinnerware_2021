package com.example.dinnerware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btngiris,btnkayit,btnyonetim;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btngiris=(Button)findViewById(R.id.button2);
    btnkayit=(Button)findViewById(R.id.button);
    img=(ImageView)findViewById(R.id.imageView2);
    img.setImageResource(R.drawable.cutlery);

    btnyonetim=(Button)findViewById(R.id.yonetimbuton);

    btngiris.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent intent2=new Intent(context,login.class);
        startActivity(intent2);
        }
    });

    btnkayit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent intent=new Intent(context,kayitol.class);
        startActivity(intent);

        }
    });

    btnyonetim.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3=new Intent(context,yonetimlogin.class);
            startActivity(intent3);
        }
    });

    }
}