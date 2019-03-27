package com.example.darag.dam_app.MoodsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.darag.dam_app.Adapters.MoodList;
import com.example.darag.dam_app.Models.Mood;
import com.example.darag.dam_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MoodsFragmentDiary extends Fragment {

    //Firebase
    DatabaseReference databaseMoods;

    //Android Layout
    ListView listView;

    List<Mood> moodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods_diary,container,false);

        databaseMoods = FirebaseDatabase.getInstance().getReference("moods");//passing a parameter ensure we get ref of root and not json tree (???)
        listView = view.findViewById(R.id.database_linear_layout);
        moodList = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        databaseMoods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                moodList.clear();

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Mood mood = ds.getValue(Mood.class);
                    moodList.add(mood);
                    Log.d("moodLog", mood.getMoodDate());
                    Log.d("moodLog", String.valueOf(mood.getMoodNum()));

                }

                //making sure its not null fixed my nullpointerexception error
                if (getActivity()!=null) {
                    MoodList adapter = new MoodList(getActivity(), moodList);
                    listView.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
