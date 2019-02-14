package com.example.darag.dam_app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.darag.dam_app.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private Button loginButton;
    private Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        regButton= findViewById(R.id.loginRegButton);

        regButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //intent used to get from one screen to another
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }
}
