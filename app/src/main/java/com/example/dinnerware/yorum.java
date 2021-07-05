package com.example.dinnerware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class yorum extends AppCompatActivity {
    RatingBar rb;
    TextView durum;
    Button yorumgonder,yorumgecis;
    ImageView yorumresim;
    veritabani vt;
    Context c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yorum);

        c=this;
        vt=new veritabani(this);

        Bundle bundle=getIntent().getExtras();
        String kuladi=bundle.getString("kuladi");

        yorumresim=(ImageView)findViewById(R.id.yorumresim);
        yorumresim.setImageResource(R.drawable.yorum);

        yorumgonder=(Button)findViewById(R.id.yorumgonder);
        yorumgecis=(Button)findViewById(R.id.yorumlarekrani);

        rb=(RatingBar)findViewById(R.id.ratingBar2);
        durum=(TextView)findViewById(R.id.durumbilgisi);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0){
                    durum.setText("Yıldız Puanı Çok Kötü");
                }else if(rating>=0.5 && rating<=2){
                    durum.setText("Yıldız Puanı Kötü");
                }else if(rating>2 && rating<=3){
                    durum.setText("Yıldız Puanı Orta");
                }else if(rating>3 && rating<=4){
                    durum.setText("Yıldız Puanı İyi");
                }else if(rating>4 && rating<=5){
                    durum.setText("Yıldız Puanı Çok İyi");
                }
            }
        });




        yorumgonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yorum=((EditText)findViewById(R.id.yorumkutusu)).getText().toString();
                String durumbilgi=durum.getText().toString();

                if(durumbilgi.equals("") && yorum.equals("")){
                    Toast.makeText(getApplicationContext(),"Lütfen Girişleri Boş Bırakmayın",Toast.LENGTH_SHORT).show();
                }else {
                    vt.yorumekle(kuladi, yorum, durumbilgi);
                    Toast.makeText(getApplicationContext(), "Yorum Eklendi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        yorumgecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),kullaniciyorumlari.class);
                startActivity(intent);
            }
        });
    }
}
