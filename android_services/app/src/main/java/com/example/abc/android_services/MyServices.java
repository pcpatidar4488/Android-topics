package com.example.abc.android_services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by abc on 3/15/2018.
 */

public class MyServices extends Service{

       final class MyThread implements Runnable {
        int service_id;

        MyThread(int service_id){
            this.service_id=service_id;
        }

           @Override
           public void run() {
               int i=0;
               synchronized (this){
                   while (i<10){
                       try {
                           wait(1500);
                           i++;
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   stopSelf(service_id);
               }
           }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new MyThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
