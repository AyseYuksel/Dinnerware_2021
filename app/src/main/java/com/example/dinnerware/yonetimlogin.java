package com.example.dinnerware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class yonetimlogin extends AppCompatActivity {
    ImageView adminresim;
    Button adminlogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yonetimlogin);

        adminresim=(ImageView)findViewById(R.id.adminresim);
        adminresim.setImageResource(R.drawable.admin);

        adminlogin=(Button)findViewById(R.id.adminloginbuton);


        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String adminkuladi=((EditText)findViewById(R.id.adminkulad)).getText().toString();
        String adminsifre=((EditText)findViewById(R.id.adminsifre)).getText().toString();


        if(adminkuladi.equals("") || adminsifre.equals("")){
           Toast.makeText(getApplicationContext(), "Lütfen Girişleri Boş Bırakmayınız ", Toast.LENGTH_LONG).show();
       } else if(adminkuladi.equals("admin") && adminsifre.equals("admin")){
            Intent intent=new Intent(getApplicationContext(),yonetimmenu.class);
            startActivity(intent);
        }
            }
        });
    }
}
