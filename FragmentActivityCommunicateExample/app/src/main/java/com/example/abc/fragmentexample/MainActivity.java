package com.example.abc.fragmentexample;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements communicate{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData() {
        FragmentManager fm = getFragmentManager();
        SecondFragment frag = (SecondFragment) fm.findFragmentById(R.id.fragmentB);
        frag.incrementData();
    }
}

   /* private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        //fragmentTransaction.add(R.id.frameLayout,fragment,"First");
        fragmentTransaction.commit(); // save the changes
    }
}
*/