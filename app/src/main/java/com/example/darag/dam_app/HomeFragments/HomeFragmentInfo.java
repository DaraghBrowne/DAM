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

public class HomeFragmentInfo extends Fragment {

    ImageButton imageButtonDepression;
    ImageButton imageButtonAnxiety;
    ImageButton imageButtonCounselling;
    ImageButton imageButtonMedication;
    ImageButton imageButtonStigma;
    ImageButton imageButtonOther;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_info,container,false);

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
                builder1.setMessage("Depression is a mental health condition which can affect thinking, energy, feelings and behaviour." +
                        "\n\nIt can vary from mild to severe, and can affect many aspects of an individual's life" +
                        "\n\nIf you think you have depression, Aware recommends that you speak to your GP or a mental health professional. This will help you to get a correct diagnosis and decide which approach to treatment is best for you. ");
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
                builder2.setMessage("The symptoms of generalised anxiety disorder can vary from person to person and be both physical and psychological." +
                        "\n\nAnxiety involves a frequent unpleasant feeling typically associated with uneasiness, apprehension and worry. It has physical, emotional and behavioural effects." +
                        "\n\nAnxiety is considered normal and adaptive when it serves to improve peoples' functioning or wellbeing. In contrast, abnormal anxiety is a chronic condition that impairs peoples' functioning and interferes with their well-being.");
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
                builder3.setMessage("Counselling is a type of talking therapy or psychological therapy. It involves talking to a counsellor about your problems. " +
                        "\n\nCounsellors are trained to listen sympathetically and can help you deal with any negative thoughts and feelings. They are also skilled at helping you express your worries and concerns.");
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
                builder4.setTitle("What is Medication and how can it help?");
                builder4.setMessage("An effective way of treating mental health illnesses may be through using medication" +
                        "\n\nA psychiatrist or GP (family doctor) can prescribe medications for mental illness." +
                        "\n\nHow do medications treat mental illnesses?\nMedications work by rebalancing the chemicals in the brain. Different types of medication act on different chemical pathways");
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
                builder5.setMessage("Stigma is defined as a sign of disgrace or discredit, which sets a person apart from others. " +
                        "Stigma can be deeply hurtful and isolating, and is one of the most significant problems encountered by people with mental health problems. Learning to live with mental health problems is made more difficult, when someone experiences the prejudice caused by stigma. " +
                        "\n\nThere are many steps we can take to help reduce the stigmas that surround mental health. One way to reduce stigma is to make sure the words you use are not hurtful and do not reinforce negative stereotypes." +
                        "\n\nOther ways include: Talking openly about mental health, educating yourself and others on the subject, Encourage equality between physical and mental illness; and show compassion for those with mental illnesses.");
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
                builder6.setTitle("Getting Help");
                builder6.setMessage("If you are suffering from any mental health issues, it is important to ask for help" +
                        "\n\nthis can start with something as simple as texting a friend or family member. Going for a walk or even a phone call can help alleviate the negative thought that may be on your mind." +
                        "\n\nShare your thoughts with your doctor and see what they have to say on the mater. remember, mental illnesses are just as important as physical illnesses." +
                        "\n\nIt is important to remember that you are not alone and that.");
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
