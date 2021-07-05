package com.example.dinnerware;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class login extends Activity {

    veritabani vt;
    Context c;
    Button kayit;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        c=this;
        vt=new veritabani(this);

        kayit=(Button)findViewById(R.id.girisyapbuton);
        img=(ImageView)findViewById(R.id.imageView3);

        img.setImageResource(R.drawable.dinnertable);



        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kulad=((EditText)findViewById(R.id.kuladi)).getText().toString();
                String sifre=((EditText)findViewById(R.id.sifre2)).getText().toString();
                Boolean kontrol = vt.checkusernamepassword(kulad, sifre);



                if (kulad.equals("") && sifre.equals("")) {

                    Toast.makeText(getApplicationContext(), "Lütfen Girişleri Boş Bırakmayınız ", Toast.LENGTH_LONG).show();

                } else if (kontrol == false) {
                    Toast.makeText(getApplicationContext(), "Kullanıcı adı veya şifre hatalı girildi.", Toast.LENGTH_LONG).show();

                } else{
                    Intent intent1 = new Intent(getApplicationContext(), menu.class);
                    intent1.putExtra("kuladi",kulad);
                    Toast.makeText(getApplicationContext(), "Başarılı ", Toast.LENGTH_LONG).show();
                    startActivity(intent1);
                }

            }
        });


    }


}