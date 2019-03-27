package com.example.darag.dam_app.EmergencyFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.darag.dam_app.R;

public class EmergencyFragmentEmails extends Fragment {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emergency_emails,container,false);

        mEditTextTo = view.findViewById(R.id.edit_text_to);
        mEditTextSubject = view.findViewById(R.id.edit_text_subject);
        mEditTextMessage = view.findViewById(R.id.edit_text_message);

        Button buttonSend = view.findViewById(R.id.button_send_email);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
        return view;
    }

    //need to get text out of edit text and add it over to email client
    private void sendMail(){
        String recipientList = mEditTextTo.getText().toString();
        //do this so can have multiple recipients
        String[] recipients = recipientList.split(",");
        //example@gmail.com, anotherone@gmail.com

        //
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        //
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients); //takes string array with email address of recipients
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822"); //makes sure we only open email clients
        startActivity(Intent.createChooser(intent, "Choose an app to send the email"));
    }
}
