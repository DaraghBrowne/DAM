package com.example.darag.dam_app.HomeFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.darag.dam_app.R;

public class HomeFragmentTab2 extends Fragment {

    ImageButton imageButtonDepression;
    ImageButton imageButtonAnxiety;
    ImageButton imageButtonCounselling;
    ImageButton imageButtonMedication;
    ImageButton imageButtonStigma;
    ImageButton imageButtonOther;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_tab2,container,false);

        imageButtonDepression = view.findViewById(R.id.imageButtonDepression);
        imageButtonAnxiety = view.findViewById(R.id.imageButtonAnxiety);
        imageButtonCounselling = view.findViewById(R.id.imageButtonCounselling);
        imageButtonMedication = view.findViewById(R.id.imageButtonMedication);
        imageButtonStigma = view.findViewById(R.id.imageButtonStigma);
        imageButtonOther = view.findViewById(R.id.imageButtonOther);

        //code for dialogue box with relevant information to show up when image buttons are pressed
        imageButtonDepression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //object for alert dialogue popup
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                //when user taps outside alert dialogue to cancel and close it
                builder1.setCancelable(true);
                //set title and message contents
                builder1.setTitle("What is Depression?");
                builder1.setMessage("This is info on Depression");
                //ok button for user to close dialogue
                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                //actually display alert dialogue when user click button
                builder1.show();
            }
        });

        imageButtonAnxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setCancelable(true);
                builder2.setTitle("What is Anxiety?");
                builder2.setMessage("This is info on Anxiety");
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder2.show();
            }
        });

        imageButtonCounselling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setCancelable(true);
                builder3.setTitle("What is Counselling?");
                builder3.setMessage("This is info on Counselling");
                builder3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder3.show();
            }
        });

        imageButtonMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(getActivity());
                builder4.setCancelable(true);
                builder4.setTitle("What is Counselling?");
                builder4.setMessage("This is info on Counselling");
                builder4.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder4.show();
            }
        });

        imageButtonStigma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(getActivity());
                builder5.setCancelable(true);
                builder5.setTitle("How can we reduce Stigma around Mental Health?");
                builder5.setMessage("This is info on Stigma");
                builder5.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder5.show();
            }
        });

        imageButtonOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder6 = new AlertDialog.Builder(getActivity());
                builder6.setCancelable(true);
                builder6.setTitle("X?");
                builder6.setMessage("X!");
                builder6.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder6.show();
            }
        });


        return view;
    }
}
