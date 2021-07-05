package com.example.dinnerware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class kayitol extends AppCompatActivity {
    veritabani vt;
    Context c;
    Button kayitbuton;
    EditText ad,soyad,kulad,sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayitol);

    c=this;
    vt=new veritabani(this);

    kayitbuton=(Button)findViewById(R.id.kayitolbuton);
    ad=(EditText)findViewById(R.id.adgiris);
    soyad=(EditText)findViewById(R.id.soyadgiris);
    kulad=(EditText)findViewById(R.id.kuladgiris);
    sifre=(EditText)findViewById(R.id.sifregiris);

    kayitbuton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String ad=((EditText)findViewById(R.id.adgiris)).getText().toString();
            String soyad=((EditText)findViewById(R.id.soyadgiris)).getText().toString();
            String kulad=((EditText)findViewById(R.id.kuladgiris)).getText().toString();
            String sifre=((EditText)findViewById(R.id.sifregiris)).getText().toString();

            if(ad.equals("") && soyad.equals("") && kulad.equals("") && sifre.equals("")){

                Toast.makeText(getApplicationContext(), "Girişlerin tamamını doldurunuz. ", Toast.LENGTH_SHORT).show();

            } else{
                Intent intent=new Intent(getApplicationContext(),login.class);
                vt.ekle(ad,soyad,kulad,sifre);
                Toast.makeText(getApplicationContext(), "Kayıt başarılı ", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        }

    });


    }

}

