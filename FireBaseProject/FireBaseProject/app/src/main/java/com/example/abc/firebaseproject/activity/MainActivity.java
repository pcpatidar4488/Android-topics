package com.example.abc.firebaseproject.activity;

import android.app.ProgressDialog;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abc.firebaseproject.R;
import com.example.abc.firebaseproject.bean.UserBean;
import com.example.abc.firebaseproject.utils.ParameterConstant;
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

        final EditText userName = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button mSubmit = (Button) findViewById(R.id.submit);

        final UserBean userBean=new UserBean();



        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = userName.getText().toString();
                String pass = password.getText().toString();

                userBean.setName(user);
                userBean.setPassword(pass);
                progressDialog.show();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(ParameterConstant.ROOT_KEY).child(ParameterConstant.NOTICE);
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