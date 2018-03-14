package com.example.abc.fcmtestapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pc on 10/7/2016.
 */
public class Preferences {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "FireBaseCloudMessaging";
    private static Preferences instance;
    private static final String REG_TOKEN = "reg_token";



    private Preferences(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public static Preferences getInstance(Context context) {
        if (instance == null) {
            instance = new Preferences(context);
        }
        return instance;
    }

    public void setRegToken(String isToken) {
        editor.putString(REG_TOKEN, isToken);
        editor.commit();
    }

    public String getRegTokenn() {
        return pref.getString(REG_TOKEN, "");
    }

}
