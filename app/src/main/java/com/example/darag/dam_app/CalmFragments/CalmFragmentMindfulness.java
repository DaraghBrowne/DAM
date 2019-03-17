package com.example.darag.dam_app.CalmFragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.darag.dam_app.R;

public class CalmFragmentMindfulness extends Fragment {

    Button mindfulness1_btn_play;
    Button mindfulness1_btn_pause;
    Button getMindfulness1_btn_restart;

    Button mindfulness2_btn_play;
    Button mindfulness2_btn_pause;
    Button getMindfulness2_btn_restart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calm_mindfulness,container,false);

        mindfulness1_btn_play = view.findViewById(R.id.mindfulness_1_play);
        mindfulness1_btn_pause = view.findViewById(R.id.mindfulness_1_pause);
        getMindfulness1_btn_restart =view.findViewById(R.id.mindfulness_1_restart);

        mindfulness2_btn_play = view.findViewById(R.id.mindfulness_2_play);
        mindfulness2_btn_pause = view.findViewById(R.id.mindfulness_2_pause);
        getMindfulness2_btn_restart =view.findViewById(R.id.mindfulness_2_restart);

        //media player used to use soundByte stored in Raw file (mindfulness audio segment)
        final MediaPlayer m1 = MediaPlayer.create(getActivity(), R.raw.mindfulness_1);
        final MediaPlayer m2 = MediaPlayer.create(getActivity(), R.raw.mindfulness_2);

        //play button for mindfulness 1
        mindfulness1_btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m2.isPlaying()){
                    m2.pause();
                }
                m1.start();
            }
        });

        //pause button for mindfulness 1
        mindfulness1_btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m1.isPlaying()){
                    m1.pause();
                }
            }
        });

        //restart button for mindfulness 1
        getMindfulness1_btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m2.isPlaying()){
                    m2.pause();
                }
                m1.pause();
                m1.seekTo(0);
                m1.start();
            }
        });


        //now same for mindfulness 2

        //play button for mindfulness 2
        mindfulness2_btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m1.isPlaying()){
                    m1.pause();
                }
                m2.start();
            }
        });

        //pause button for mindfulness 2
        mindfulness2_btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m2.isPlaying()){
                    m2.pause();
                }
            }
        });

        //restart button for mindfulness 2
        getMindfulness2_btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m1.isPlaying()){
                    m1.pause();
                }
                m2.pause();
                m2.seekTo(0);
                m2.start();
            }
        });


        return view;
    }
}
