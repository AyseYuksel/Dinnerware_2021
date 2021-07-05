package com.example.dinnerware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class siptamamla extends AppCompatActivity {
    ListView liste;
    Button onay,sms;
    TextView toplamtutar2;
    veritabani vt;
    Context c;
    String tumsiparisler=" ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siptamamla);

        c=this;
        vt = new veritabani(this);

        Bundle bundle2= getIntent().getExtras();
        String kuladi=bundle2.getString("kuladi");

        liste=(ListView)findViewById(R.id.sipliste);
        Bundle bundle=getIntent().getExtras();
        ArrayList<String>yiyecekler=bundle.getStringArrayList("siparray");

        ArrayList<String>temporary=new ArrayList<String>();
        for(String y:yiyecekler){
            if(!(temporary.contains(y))) {
                temporary.add(y);
            }
        }


        ArrayAdapter<String>items=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,temporary);
        liste.setAdapter(items);

        toplamtutar2=(TextView)findViewById(R.id.texttutar);
        Bundle bundle1= getIntent().getExtras();
        String toplamtut=bundle1.getString("toplamtutar");
        toplamtutar2.setText("TOPLAM TUTAR  : "+ toplamtut);

        onay=(Button)findViewById(R.id.siponay);

        onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(String a:temporary) {
                    tumsiparisler += a;
                }
               vt.siparisekle(kuladi,tumsiparisler,toplamtut);
               Toast.makeText(getApplicationContext(), "Kayıt başarılı ", Toast.LENGTH_SHORT).show();
            }
        });

        sms=(Button)findViewById(R.id.sipsms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),smsolustur.class);
                intent.putExtra("siparray",temporary);
                intent.putExtra("tutar",toplamtut);
                startActivity(intent);
            }
        });


    }
}
