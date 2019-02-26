package com.example.darag.dam_app.Models;

public class Mood {

    String moodId;
    String moodType;
    String moodNote;

    //constructor - will be used while we read the values!
    public Mood(){

    }

    //constructor to initialise our variables
    public Mood(String moodId, String moodType, String moodNote) {
        this.moodId = moodId;
        this.moodType = moodType;
        this.moodNote = moodNote;
    }

    public String getMoodId() {
        return moodId;
    }

    public String getMoodType() {
        return moodType;
    }

    public String getMoodNote() {
        return moodNote;
    }
}
