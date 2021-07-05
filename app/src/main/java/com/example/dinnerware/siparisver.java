package com.example.dinnerware;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class siparisver extends AppCompatActivity {

    CheckBox domatescorbasi,mantarcorbasi,peynirlimakarna,iclikofte,yapraksarma,kizarmistavuk,hamburger,mevsimsalata,
    adanakebap,patateskizartma,doner,ekler,kazandibi,kunefe,baklava,soda,su,kola,gazoz,turkkahvesi;

    Button siparistamamla;
    TextView tutar;
  static ArrayList<String> siparisler = new ArrayList<String>(20);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siparisver);

     domatescorbasi=(CheckBox)findViewById(R.id.domatescorbasi);
     mantarcorbasi=(CheckBox)findViewById(R.id.mantarcorbasi);
     peynirlimakarna=(CheckBox)findViewById(R.id.peynirlimakarna);
     iclikofte=(CheckBox)findViewById(R.id.iclikofte);
      yapraksarma=(CheckBox)findViewById(R.id.yapraksarma);
     kizarmistavuk=(CheckBox)findViewById(R.id.kizarmistavuk);
     hamburger=(CheckBox)findViewById(R.id.hamburger);
     mevsimsalata=(CheckBox)findViewById(R.id.mevsimsalata);
     adanakebap=(CheckBox)findViewById(R.id.adanakebap);
     patateskizartma=(CheckBox)findViewById(R.id.patateskizartma);
     doner=(CheckBox)findViewById(R.id.doner);
     ekler=(CheckBox)findViewById(R.id.ekler);
     kazandibi=(CheckBox)findViewById(R.id.kazandibi);
     kunefe=(CheckBox)findViewById(R.id.kunefe);
     baklava=(CheckBox)findViewById(R.id.baklava);
     soda=(CheckBox)findViewById(R.id.soda);
     su=(CheckBox)findViewById(R.id.su);
     kola=(CheckBox)findViewById(R.id.kola);
     gazoz=(CheckBox)findViewById(R.id.gazoz);
     turkkahvesi=(CheckBox)findViewById(R.id.turkkahvesi);

     tutar=(TextView)findViewById(R.id.tutar);
     siparistamamla=(Button)findViewById(R.id.siptamamla);

        Bundle bundle1= getIntent().getExtras();
        String kuladi=bundle1.getString("kuladi");

     siparistamamla.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            kontrolet(v);
            Intent intent=new Intent(getApplicationContext(),siptamamla.class);
            intent.putExtra("siparray",siparisler);
            intent.putExtra("toplamtutar",tutar.getText().toString());
            intent.putExtra("kuladi",kuladi);
            startActivity(intent);
         }
     });


    }

    public void kontrolet(View view) {
        int para = 0;

        if (domatescorbasi.isChecked()) {
            para += 5;
            siparisler.add("Domates Çorbasi  5TL");
        }

        if (mantarcorbasi.isChecked()) {
            para += 5;
            siparisler.add("Mantar Çorbası  5TL");
        }
        if (peynirlimakarna.isChecked()) {
            para += 8;
            siparisler.add("Peynirli Makarna  8TL");
        }
        if (iclikofte.isChecked()) {
            para += 8;
            siparisler.add("İçli Köfte  8TL");
        }
        if (yapraksarma.isChecked()) {
            para += 10;
            siparisler.add("Yaprak Sarma  10TL");
        }
        if (kizarmistavuk.isChecked()) {
            para += 13;
            siparisler.add("Kızarmış Tavuk  13TL");
        }
        if (hamburger.isChecked()) {
            para += 15;
            siparisler.add("Hamburger  15TL");
        }
        if (mevsimsalata.isChecked()) {
            para += 10;
            siparisler.add("Mevsim Salatası  10TL");
        }
        if (adanakebap.isChecked()) {
            para += 18;
            siparisler.add("Adana Kebap  18TL");
        }
        if (patateskizartma.isChecked()) {
            para += 10;
            siparisler.add("Patates Kızartması  10TL");
        }
        if (doner.isChecked()) {
            para += 13;
            siparisler.add("Döner  13TL");
        }
        if (ekler.isChecked()) {
            para += 10;
            siparisler.add("Ekler  10TL");
        }
        if (kazandibi.isChecked()) {
            para += 10;
            siparisler.add("Kazandibi  10TL");
        }
        if (kunefe.isChecked()) {
            para += 18;
            siparisler.add("Künefe  18TL");
        }
        if (baklava.isChecked()) {
            para += 13;
            siparisler.add("Baklava  13TL");
        }
        if (soda.isChecked()) {
            para += 3;
            siparisler.add("Soda  3TL");
        }
        if (su.isChecked()) {
            para += 2;
            siparisler.add("Su  2TL");
        }
        if (kola.isChecked()) {
            para += 5;
            siparisler.add("Kola  5TL");
        }
        if (gazoz.isChecked()) {
            para += 5;
            siparisler.add("Gazoz  5TL");
        }
        if (turkkahvesi.isChecked()) {
            para += 5;
            siparisler.add("Türk Kahvesi  5TL");
        }

        String deger = Integer.toString(para);
        tutar.setText("  " + deger + "  TL");

    }
}
