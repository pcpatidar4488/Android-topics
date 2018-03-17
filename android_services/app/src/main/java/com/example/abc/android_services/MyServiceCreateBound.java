package com.example.abc.android_services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by abc on 3/17/2018.
 */

public class MyServiceCreateBound extends Service {
    @Nullable
    private final IBinder mBinder = new LocalService();
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalService extends Binder {

        MyServiceCreateBound getService(){

            return MyServiceCreateBound.this;
        }

    }

    public String getFirstMessage(){

        return "Hello welcom";
    }

    public String getSecoundMessage(){

        return "This is bound service message";
    }
}
