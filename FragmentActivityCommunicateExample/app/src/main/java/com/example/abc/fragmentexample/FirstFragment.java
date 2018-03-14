package com.example.abc.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by abc on 3/14/2018.
 */

public class FirstFragment extends Fragment implements View.OnClickListener {

    Button firstButton;
    communicate cm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cm = (communicate) getActivity();
        firstButton = (Button) getActivity().findViewById(R.id.button1);
        firstButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cm.sendData();
    }
}
