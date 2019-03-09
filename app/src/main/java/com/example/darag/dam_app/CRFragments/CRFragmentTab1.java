package com.example.darag.dam_app.CRFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darag.dam_app.R;

public class CRFragmentTab1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //specify layout we want to show for the fragment
        return inflater.inflate(R.layout.fragment_cr_tab1,container,false);
    }
}
