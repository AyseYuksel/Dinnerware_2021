package com.example.dinnerware;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class suprizsecim extends AppCompatActivity {
    RadioGroup rg;
    RadioButton secim1,secim2,secim3,secim4;
    Button bilgial,rastgele;
    TextView rastgelegoster;

    static String[] corba={"Domates Çorbası","Mantar Çorbası"};
    static String[] anayemek={"Peynirli Makarna","İçli Köfte","Yaprak Sarma","Kızarmış Tavuk","Hamburger"
    ,"Mevsim Salatası","Adana Kebap","Patates Kızartması","Döner"};
    static String[] tatli={"Ekler","Kazandibi","Künefe","Baklava"};
    static String[] icecek={"Soda","Su","Kola","Gazoz","Turk Kahvesi"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suprizsecim);

    rg=(RadioGroup)findViewById(R.id.yemekradio);
    secim1=(RadioButton)findViewById(R.id.secim1);
    secim2=(RadioButton)findViewById(R.id.secim2);
    secim3=(RadioButton)findViewById(R.id.secim3);
    secim4=(RadioButton)findViewById(R.id.secim4);

    bilgial=(Button)findViewById(R.id.suprizbilgi);
    rastgele=(Button)findViewById(R.id.menuolustur);

    rastgelegoster=(TextView)findViewById(R.id.menugoruntule);

    bilgial.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(suprizsecim.this);
            builder.setTitle("Supriz seçim nedir?");
            builder.setMessage("Ne yiyeceğini kararlaştıramayanlar için yapılan menü varyasyonu seçimine göre rastgele menü oluşturan bir program. ");
            builder.setPositiveButton("Tamam",null);
            builder.show();
        }
    });

    Random random=new Random();


    rastgele.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(secim1.isChecked()){
                int corbasayi=random.nextInt(2);
                int anayemeksayi=random.nextInt(10);
                String corbasec=corba[corbasayi];
                String anayemeksec=anayemek[anayemeksayi];
                rastgelegoster.setText("Çorba : "+corbasec+"\n Ana Yemek : "+anayemeksec);
            }else if(secim2.isChecked()){
                int anayemeksayi=random.nextInt(10);
                int tatlisayi=random.nextInt(4);
                String anayemeksec=anayemek[anayemeksayi];
                String tatlisec=tatli[tatlisayi];
                rastgelegoster.setText("Ana Yemek : "+anayemeksec+"\n Tatlı : "+tatlisec);
            }else if(secim3.isChecked()){
                int tatlisayi=random.nextInt(4);
                int iceceksayi=random.nextInt(6);
                String tatlisec=tatli[tatlisayi];
                String iceceksec=icecek[iceceksayi];
                rastgelegoster.setText("Tatlı : "+tatlisec+"\n İçecek : "+iceceksec);
            }else if(secim4.isChecked()){
                int corbasayi=random.nextInt(2);
                int anayemeksayi=random.nextInt(10);
                int tatlisayi=random.nextInt(4);
                String corbasec=corba[corbasayi];
                String anayemeksec=anayemek[anayemeksayi];
                String tatlisec=tatli[tatlisayi];
                rastgelegoster.setText("Çorba : "+corbasec+"\n Ana Yemek : "+anayemeksec+"\n Tatlı : "+tatlisec);
            }else{
                Toast.makeText(getApplicationContext(), "Lütfen Menü Varyasyonu Seçimi Yapınız ", Toast.LENGTH_LONG).show();
            }
        }
    });



    }
}
