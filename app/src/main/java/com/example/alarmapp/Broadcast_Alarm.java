package com.example.alarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
// THIS CLASS EXTENDS INSIDE THE ANDROID MANIFEST
public class Broadcast_Alarm extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        // WITH THE HELP OF RECEIVE METHOD WE ARE ABLE TO RECEIVED THE BROADCAST OF ALARM
        // THIS IS A BACKGROUND ACTIVITY PERFORM DURING
        // WE CAN ALSO PERFORM ANY KIND OF SERVICES
         
        mp = MediaPlayer.create(context , Settings.System.DEFAULT_RINGTONE_URI);
        // CONTINUE LOOPED
        mp.setLooping(true);

        mp.start();

    }
}
