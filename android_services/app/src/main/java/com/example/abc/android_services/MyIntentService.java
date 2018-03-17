package com.example.abc.android_services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by abc on 3/15/2018.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("My worker thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int count=0;
        synchronized (this){
            while (count<10){
                try {
                    wait(15000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
