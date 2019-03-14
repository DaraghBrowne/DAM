package com.example.darag.dam_app.MoodsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darag.dam_app.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MoodsFragmentTab3 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods_tab3,container,false);

        //retrieve Linechart from xml... get instance of line chart
        LineChart chart = view.findViewById(R.id.moodGraph);

/*
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference moodsRef = rootRef.child("moods");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Entry> entries = new ArrayList<Entry>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    int moodDate = (int) ds.child("moodDate").getValue();
                    int moodType = 1;
                    entries.add(new Entry(moodDate, moodType));
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        moodsRef.addListenerForSingleValueEvent(eventListener);
*/

        //load Firebase mood data into some sort of data structure that i can loop through to plot the line chart.
        //need moodDate and moodType
        //YourData[] dataObjects = ...;

        //entry class represents single entry on the line chart ie x and y axis
        //List<Entry> entries = new ArrayList<Entry>();

        /*
        for (YourData data : dataObjects) {

            // turn your data into Entry objects
            entries.add(new Entry(data.getValueX(), data.getValueY()));
        }*/


        return view;
    }
}
