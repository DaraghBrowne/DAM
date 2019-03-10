package com.example.darag.dam_app.SettingsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darag.dam_app.Adapters.SectionsPagerAdapter;
import com.example.darag.dam_app.R;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);

        //get the fragment manager - getChildFragmentManager() needed for nesting fragments
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        //adding fragments to the adapter
        adapter.addFragment(new SettingsFragmentTab1());
        adapter.addFragment(new SettingsFragmentTab2());
        //declare viewpager object
        ViewPager viewpager = view.findViewById(R.id.home_fragment_container);

        viewpager.setAdapter(adapter);

        //connect to tablayout
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);

        //set text in tabs
        tabLayout.getTabAt(0).setText("Settings");
        tabLayout.getTabAt(1).setText("Configure");


        return view;
    }
}