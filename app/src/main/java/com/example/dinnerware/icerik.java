package com.example.dinnerware;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class icerik extends AppCompatActivity {
    ImageView tarifresim;
    TextView tarif,yemekadi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icerik);

        tarifresim=(ImageView)findViewById(R.id.tarifresim);
        tarifresim.setImageResource(R.drawable.recipebook);

        tarif=(TextView)findViewById(R.id.yemektarifi);
        yemekadi=(TextView)findViewById(R.id.yemekadi);

        final String[] yemekliste={"Seçim Yapınız","Domates Çorbası","Mantar Çorbası","Içli Köfte","Yaprak Sarma","Hamburger","Adana Kebap","Döner","Künefe","Baklava"
        ,"Kazandibi"};


        Spinner yemekspinner=(Spinner)findViewById(R.id.yemekspinner);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,yemekliste);
        yemekspinner.setAdapter(adapter);

        yemekspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                  yemekadi.setText(yemekliste[position]);
                  if(position==1){
                      tarifresim.setImageResource(R.drawable.domatescorbasi);
                      tarif.setText("Mevsiminde toplanmış domatesler ile hazırlanmış müthiş bir lezzet.Üzerinde rendelenmiş kaşar peyniri ile servis edilen sıcacık domates çorbası." );
                  }
                  if(position==2){
                      tarifresim.setImageResource(R.drawable.mantarcorbasi);
                      tarif.setText("Taze toplanmış mantarlar ile hazırlanan kremalı mantar çorbası.Servis edilirken üzerine opsiyonel olarak karabiber ilavesi yapılabilir.");
                  }
                  if(position==3){
                      tarifresim.setImageResource(R.drawable.iclikofte);
                      tarif.setText("Hatay yöresinin tarifiyle yapılan içli köfte, hazırlanırken taze bulgur ve içerisinde günlük kıymalar kullanılarak kızartılarak sıcak servis edilir.");
                  }
                  if(position==4){
                      tarifresim.setImageResource(R.drawable.yapraksarma);
                      tarif.setText("İçerisinde pirinç,kıyma ve salça kullanılarak mevsiminde toplanmış taze yapraklar ile yapılır.Günün her anı yenilebilir olup taze servis edilmektedir.");
                  }
                  if(position==5){
                      tarifresim.setImageResource(R.drawable.hamburger);
                      tarif.setText("Taze ekmekler arasına günlük kıyma,marul,domates,soğan ve özel soslar kullanılarak yapılır.Sıcak servis edilir.Opsiyonel olarak sos eklemesi yapılabilir.");
                  }
                  if(position==6){
                        tarifresim.setImageResource(R.drawable.adanakebap);
                        tarif.setText("Odun fırınında pişirilir.Dana eti kullanılarak adana yöresinin yapılış biçimi esas olarak hazırlanır.Yanında soğan,domates ve maydonoz servisi yapılır");
                  }if(position==7){
                        tarifresim.setImageResource(R.drawable.doner);
                        tarif.setText("Hatayın yöresel baharatlarıyla iyice terbiyelenmiş ve pişirilmiş tavuk döner dışı kızartılmış lavaş içerisinde patates,turşu ve soslarla dürülüp servis edilir.");
                  }
                  if(position==8){
                        tarifresim.setImageResource(R.drawable.kunefe);
                        tarif.setText("Kadayıfı tereyağıyla beraber odun ateşinde pişirilmiş ortası künefe peyniri içerir ve sıcak servis edilir.İsteğe bağlı olarak üzerine kaymak ya da dondurma eklenebilir.");
                  }
                  if(position==9){
                        tarifresim.setImageResource(R.drawable.baklava);
                        tarif.setText("İnce yufkaların arasına taze antep fıstığı konularak pişirilip daha sonra üstü şerbet ile tatlandırılır.Servisinde isteğe bağlı olarak dondurma veya kaymak eklenilebilir.");
                  }
                  if(position==10){
                        tarifresim.setImageResource(R.drawable.kazandibi);
                        tarif.setText("İçerisinde tavuk göğsü kullanılarak dibi tutturularak hafifçe kızartılan muhallebidir.");
                  }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
