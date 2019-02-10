package com.example.darag.dam_app.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darag.dam_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RegisterActivity extends AppCompatActivity {

    private EditText userEmail, userPassword, userPassword2, userName;
    private Button regBtn ;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail = findViewById(R.id.regMail);
        userPassword = findViewById(R.id.regPassword);
        userPassword2 = findViewById(R.id.regPasswordConfirm);
        userName = findViewById(R.id.regUsername);
        regBtn = findViewById(R.id.regButton);

        mAuth = FirebaseAuth.getInstance();


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                final String password2 = userPassword2.getText().toString();
                final String name = userName.getText().toString();

                if( email.isEmpty() || name.isEmpty() || password.isEmpty() || !password.equals(password2) ){

                    //error message will be displayed if not all fields are filled in or pws do not match
                    showMessage("Please fill in all fields correctly");

                }
                else{

                    //everything is g - start creating account
                    CreateUserAccount(email,name, password);

                }


            }
        });

    }

    private void CreateUserAccount(String email, String name, String password) {

        //method to create user account with specific email and password
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //user account created successfully
                            showMessage("Account Created!");

                            //after we create an account we need to update their name maybe?

                        }
                        else{

                            //account not successfully created
                            showMessage("account creation error" + task.getException().getMessage());
                        }
                    }
                });
    }

    //toast messages method
    private void showMessage(String s) {

        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();

    }
}
