package com.example.abc.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by abc on 3/14/2018.
 */

public class SecondFragment extends Fragment {

    int count;
    TextView textView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView1 = (TextView) getActivity().findViewById(R.id.textView1);
    }

    public void incrementData(){
        String string = textView1.getText().toString();
        count = Integer.parseInt(string);
        count++;
        textView1.setText(String.valueOf(count));
    }
}
