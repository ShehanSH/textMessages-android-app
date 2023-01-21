package com.example.textmessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        Button button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextMobileNo=findViewById(R.id.text1);
                EditText editTextMessage=findViewById(R.id.textMsg);
                String mobileNo=editTextMobileNo.getText().toString();
                String message=editTextMessage.getText().toString();


                try{
                    if(!mobileNo.equals("") && !message.equals("")){
                        SmsManager smgr = SmsManager.getDefault();
                        smgr.sendTextMessage(mobileNo,null,message,null,null);
                        Toast.makeText(getApplicationContext(),"SMS Sent to "+mobileNo,Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"SMS Sending Failed",Toast.LENGTH_LONG).show();
                }



            }


        });



    }
}