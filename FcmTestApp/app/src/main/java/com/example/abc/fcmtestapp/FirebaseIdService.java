package com.example.abc.fcmtestapp;

import android.preference.Preference;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import timber.log.Timber;

public class FirebaseIdService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";


    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        Timber.i("aaaaaa"+refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
        Preferences.getInstance(getApplicationContext()).setRegToken(token);
        Timber.i("aaaaaa"+Preferences.getInstance(getApplicationContext()).getRegTokenn());
    }
}