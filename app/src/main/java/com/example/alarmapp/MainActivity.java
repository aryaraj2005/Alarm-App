package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static  final int ALR_REQ_CODE = 100;
    EditText edtset;
    Button btnset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edtset = findViewById(R.id.editset);
         // WE DEFINE IT AT HER BECAUSE NOW WE CAN USE IT AS UNIVERSAL WE USE IT FOR MANY BUTTONS
         AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
         btnset=findViewById(R.id.btnset);
         btnset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // TEXT TO STRING THEN FROM STRING TO INTEGER TYPE CAST
                 int time = Integer.parseInt(edtset.getText().toString());
                 // FROM CURRENT TIME SET WE GET OUR CURRENT TIME OF SETTING OF ALARM AND WE MULTIPLY BY 1000 TO CONVERT IN MILLI SECOND
                 long trigger_time = System.currentTimeMillis()+(time*1000);
                 // NOW FOR EXECUTE THE RECEIVING THE BROADCAST FROM ALARM WE HAVE REQUIRED A RECEIVER  WHICH CAN
                 // RECEIVED THE BROADCAST OF ALARM , FOR OT CREATE A NEW JAVA CLASS
                 Intent intentalrm = new Intent(MainActivity.this , Broadcast_Alarm.class);
                 // WE HAVE REQUIRES A PENDING INTENT FOR ALARM_MANAGER
                 PendingIntent pendintalrm = PendingIntent.getBroadcast(MainActivity.this , ALR_REQ_CODE , intentalrm ,
                         PendingIntent.FLAG_UPDATE_CURRENT);
                 alarmManager.set(alarmManager.RTC_WAKEUP ,trigger_time  , pendintalrm);

             }
         });


    }
}