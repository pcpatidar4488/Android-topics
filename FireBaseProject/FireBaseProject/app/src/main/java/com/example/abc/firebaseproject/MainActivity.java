package com.example.abc.firebaseproject;

import android.app.ProgressDialog;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    public static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        final EditText editTex = (EditText) findViewById(R.id.editText);
        final UserBean userBean=new UserBean();
        userBean.setName("name1");
        userBean.setEmail("email1");
        userBean.setMobile("mobile1");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Root_Key");
                databaseReference.child("" +  SystemClock.currentThreadTimeMillis()).setValue(userBean, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        progressDialog.dismiss();
                        if (databaseError == null) {
                            Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        i++;
                    }
                });
            }
        });
    }
}