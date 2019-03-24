package com.example.darag.dam_app.SettingsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.darag.dam_app.R;

public class SettingsFragmentTab2 extends Fragment {

    Button blue_btn;
    Button green_btn;
    Button red_btn;
    Button yellow_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_tab2,container,false);

        blue_btn = view.findViewById(R.id.blueButton);
        green_btn = view.findViewById(R.id.greenButton);
        red_btn = view.findViewById(R.id.redButton);
        yellow_btn = view.findViewById(R.id.yellowButton);

        blue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }
}
