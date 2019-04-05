package com.example.darag.dam_app.MoodsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darag.dam_app.Models.Mood;
import com.example.darag.dam_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MoodsFragmentTracker extends Fragment {

    EditText editTextMoodNote;
    Button buttonAddMood;
    SeekBar seekBarMoods;

    TextView textViewNum;

    DatabaseReference databaseMoods;
    FirebaseUser user;
    String uid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods_tracker, container, false);

        databaseMoods = FirebaseDatabase.getInstance().getReference("moods");//passing a parameter ensure we get ref of root and not json tree (???)
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        editTextMoodNote = view.findViewById(R.id.editTextMood);
        buttonAddMood = view.findViewById(R.id.buttonAddMood);
        seekBarMoods = view.findViewById(R.id.seekbarMoods);
        textViewNum = view.findViewById(R.id.textViewNum);
        textViewNum.setText("Current Mood:\n5/10");

        seekBarMoods.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewNum.setText("Current Mood:\n"+i+"/10");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonAddMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMood();
            }
        });
        return view;

    }


    private void addMood() {
        String moodNote = editTextMoodNote.getText().toString();
        int moodNum= seekBarMoods.getProgress();
        String moodDate = String.valueOf(new Date().getTime());

        //if moodNote box is not empty we will add it to fireabase database

            //creates unique string inside moods for id
            String id = databaseMoods.push().getKey();

            //new mood var
            Mood mood = new Mood(id, moodNum, moodNote, moodDate);

            //id will be diff for each set of values entered
            databaseMoods.child(uid).child(id).setValue(mood);

            Toast.makeText(getActivity(), "Mood added!", Toast.LENGTH_LONG).show();
    }
}
