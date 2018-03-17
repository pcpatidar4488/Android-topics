package com.example.abc.android_services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    MyServiceCreateBound myServiceCreateBound;
    Boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.txtView);
        Intent intent = new Intent(this,MyServiceCreateBound.class);
        bindService(intent,mConnection,BIND_AUTO_CREATE);
    }

    public void startService(View view) {
      /*  Intent intent = new Intent(this,MyServices.class);
        startService(intent);*/
      String message = myServiceCreateBound.getFirstMessage();
      txtView.setText(message);


    }

    public void stopService(View view) {

      /*  Intent intent = new Intent(this,MyServices.class);
        stopService(intent);*/
        String message = myServiceCreateBound.getSecoundMessage();
        txtView.setText(message);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyServiceCreateBound.LocalService localService = (MyServiceCreateBound.LocalService) service;
            myServiceCreateBound = localService.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
