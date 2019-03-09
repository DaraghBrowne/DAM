package com.example.darag.dam_app.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

//class that stores fragments for tabs
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "SectionsPagerAdapter";

    //list to hold our fragments so we can swap through them with the tabs
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //return fragment we on
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        //look at count
        return mFragmentList.size();
    }

    //add function for adding fragments
    public void addFragment(Fragment fragment){

        mFragmentList.add(fragment);
    }

}
