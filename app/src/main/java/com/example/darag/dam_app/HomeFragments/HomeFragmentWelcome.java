package com.example.darag.dam_app.HomeFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darag.dam_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragmentWelcome extends Fragment {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String name = user.getDisplayName();
    TextView textViewUserName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //specify layout we want to show for the fragment
        View view = inflater.inflate(R.layout.fragment_home_welcome,container,false);

        textViewUserName = view.findViewById(R.id.welcome_text);
        textViewUserName.setText("Welcome "+ name + " to DAM");

        return view;


    }
}
