package com.example.darag.dam_app.Models;

public class Mood {

    String moodId;
    int moodNum;
    String moodNote;
    String moodDate;


    //constructor - will be used while we read the values!
    public Mood(){

    }

    //constructor to initialise our variables
    public Mood(String moodId, int moodNum, String moodNote, String moodDate) {
        this.moodId = moodId;
        this.moodNum = moodNum;
        this.moodNote = moodNote;
        this.moodDate = moodDate;
    }

    public String getMoodId() {
        return moodId;
    }

    public int getMoodNum() {
        return moodNum;
    }

    public String getMoodNote() {
        return moodNote;
    }

    public String getMoodDate() {
        return moodDate;
    }
}
