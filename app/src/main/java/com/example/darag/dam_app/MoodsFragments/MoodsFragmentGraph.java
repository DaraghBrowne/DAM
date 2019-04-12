package com.example.darag.dam_app.MoodsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darag.dam_app.Models.Mood;
import com.example.darag.dam_app.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class MoodsFragmentGraph extends Fragment{

    //Firebase
    DatabaseReference databaseMoods;
    FirebaseUser user;
    String uid;

    LineChart chart;
    List<Mood> moodList;
    List<Entry> entries;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods_graph,container,false);

        databaseMoods = FirebaseDatabase.getInstance().getReference("moods");//passing a parameter ensure we get ref of root and not json tree (???)
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        //retrieve Linechart from xml... get instance of line chart
        chart = view.findViewById(R.id.moodGraph);

        moodList = new ArrayList<>();
        entries = new ArrayList<>();

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();

        databaseMoods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                moodList.clear();
                int i = 0;

                for(DataSnapshot ds : dataSnapshot.child(uid).getChildren()){
                    Mood mood = ds.getValue(Mood.class);
                    moodList.add(mood);
                    entries.add(new Entry(i,mood.getMoodNum()));
                    i++;
                }

                LineDataSet dataSet = new LineDataSet(entries, "Moods over time"); // add entries to dataset
                //styling
                dataSet.setColor(R.color.color5);
                dataSet.setDrawCircles(false);
                chart.setDrawGridBackground(false);
                chart.setDrawBorders(false);
                chart.setPinchZoom(false);
                chart.setDoubleTapToZoomEnabled(false);

                chart.getDescription().setEnabled(false);

                YAxis leftAxis = chart.getAxisLeft();
                leftAxis.setDrawLabels(true);
                leftAxis.setAxisMaximum(10);
                leftAxis.setAxisMinimum(0);

                YAxis rightAxis = chart.getAxisRight();
                rightAxis.setEnabled(false);

                XAxis xAxis = chart.getXAxis();
                xAxis.setEnabled(false);

                LineData lineData = new LineData(dataSet);
                chart.setData(lineData);
                chart.invalidate(); // refresh
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}