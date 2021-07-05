package com.example.dinnerware;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class smsolustur extends AppCompatActivity {

    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;
    TextView siparisozet,tutarozet;
    Button smsgonder;
    EditText telefonno;
    String listem=" ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smsolustur);

        telefonno=(EditText)findViewById(R.id.telefonno);
        siparisozet=(TextView)findViewById(R.id.siparislerozet);
        tutarozet=(TextView)findViewById(R.id.tutarozet);
        smsgonder=(Button)findViewById(R.id.smsgonder);


        Bundle bundle1=getIntent().getExtras();
        ArrayList<String> yiyecekler=bundle1.getStringArrayList("siparray");

        Bundle bundle2=getIntent().getExtras();
        String toplamtut=bundle2.getString("tutar");

        tutarozet.setText(toplamtut);

        for(String i:yiyecekler){
            listem+=i+"\n";

        }
        siparisozet.setText(listem);

        smsgonder.setEnabled(false);
        if(izinkontrol(Manifest.permission.SEND_SMS)){
            smsgonder.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        smsgonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder(v);
            }
        });
    }

    public void gonder(View v){
        String telno=telefonno.getText().toString();
        String mesaj=siparisozet.getText().toString()+"\n"+tutarozet.getText().toString();

        if(telno==null || mesaj==null || telno.length()==0 || mesaj.length()==0){
            return;
        }
        if(izinkontrol(Manifest.permission.SEND_SMS)){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(telno,null,mesaj,null,null);
            Toast.makeText(this,"mesaj gönderildi",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"mesaj gönderilmedi",Toast.LENGTH_SHORT).show();
        }

    }
    public boolean izinkontrol(String izin){
        int check= ContextCompat.checkSelfPermission(this,izin);
        return(check== PackageManager.PERMISSION_GRANTED) ;

    }

}