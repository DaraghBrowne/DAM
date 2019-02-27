package com.example.darag.dam_app.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darag.dam_app.Models.Mood;
import com.example.darag.dam_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MoodsFragment extends Fragment {

    EditText editTextMoodNote;
    Button buttonAddMood;
    Spinner spinnerMoods;

    DatabaseReference databaseMoods;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods,container,false);

        databaseMoods = FirebaseDatabase.getInstance().getReference("moods");//passing a parameter ensure we get ref of root and not json tree (???)

         editTextMoodNote = view.findViewById(R.id.editTextMood);
         buttonAddMood = view.findViewById(R.id.buttonAddMood);
         spinnerMoods = view.findViewById(R.id.spinnerMoods);

         buttonAddMood.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                addMoodNote();
             }
         });
         return view;

    }


    private void addMoodNote(){
        String moodNote = editTextMoodNote.getText().toString();
        String moodType = spinnerMoods.getSelectedItem().toString();

        //if moodNote box is not empty we will add it to fireabse database
        if(!TextUtils.isEmpty(moodNote)){

            //creates unique string inside moods for id
            String id = databaseMoods.push().getKey();

            //new mood type var
            Mood mood = new Mood(id, moodType, moodNote);

            //id will be diff for each set of values entered
            databaseMoods.child(id).setValue(mood);

            Toast.makeText(getActivity(),"Mood Note added!", Toast.LENGTH_LONG).show();
        }
        else    {
            Toast.makeText(getActivity(),"Please enter your mood note", Toast.LENGTH_LONG);
        }


    }
}
