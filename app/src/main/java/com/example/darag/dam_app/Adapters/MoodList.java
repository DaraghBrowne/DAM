package com.example.darag.dam_app.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.darag.dam_app.Models.Mood;
import com.example.darag.dam_app.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MoodList extends ArrayAdapter<Mood> {
    private Activity context;
    private List<Mood> moodList;

    public MoodList(Activity context, List<Mood> moodList){
        super(context, R.layout.list_layout, moodList);
        this.context = context;
        this.moodList = moodList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewMNote = listViewItem.findViewById(R.id.textViewDisplayMNote);
        TextView textViewMDate = listViewItem.findViewById(R.id.textViewDisplayMDate);
        TextView textViewMNum = listViewItem.findViewById(R.id.textViewDisplayMNum);

        Mood mood = moodList.get(position);

        //make Mood Date readable
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        String x = mood.getMoodDate();
        long milliSeconds= Long.parseLong(x);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        String calenderOutput = formatter.format(calendar.getTime());


        textViewMDate.setText("Date Logged: " + calenderOutput);
        textViewMNum.setText("Mood Rating: " + mood.getMoodNum()+"/10");
        textViewMNote.setText("Mood Note: " + mood.getMoodNote());

        return listViewItem;
    }
}
