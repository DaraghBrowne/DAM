package com.example.darag.dam_app.CRFragments;


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
import com.example.darag.dam_app.MoodsFragments.MoodsFragmentTab1;
import com.example.darag.dam_app.MoodsFragments.MoodsFragmentTab2;
import com.example.darag.dam_app.MoodsFragments.MoodsFragmentTab3;
import com.example.darag.dam_app.R;

public class CRFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cr,container,false);

        //get the fragment manager - getChildFragmentManager() needed for nesting fragments
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        //adding fragments to the adapter
        adapter.addFragment(new CRFragmentTab1());
        adapter.addFragment(new CRFragmentTab2());
        adapter.addFragment(new CRFragmentTab3());
        //declare viewpager object
        ViewPager viewpager = view.findViewById(R.id.home_fragment_container);

        viewpager.setAdapter(adapter);

        //connect to tablayout
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);

        //set text in tabs
        tabLayout.getTabAt(0).setText("Emergency");
        tabLayout.getTabAt(1).setText("Contacts");
        tabLayout.getTabAt(2).setText("Email");


        return view;
    }

}
