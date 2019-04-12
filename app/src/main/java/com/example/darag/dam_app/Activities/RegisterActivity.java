package com.example.darag.dam_app.Activities;

import android.content.Intent;
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
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText userEmail, userPassword, userPassword2, userName;
    private Button regBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail = findViewById(R.id.regMail);
        userPassword = findViewById(R.id.regPassword);
        userPassword2 = findViewById(R.id.regPasswordConfirm);
        userName = findViewById(R.id.regUserName);
        regBtn = findViewById(R.id.regButton);

        mAuth = FirebaseAuth.getInstance();


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                final String password2 = userPassword2.getText().toString();
                final String name = userName.getText().toString();

                if (email.isEmpty() || name.isEmpty() || password.isEmpty() || !password.equals(password2)) {

                    //error message will be displayed if not all fields are filled in or pws do not match
                    showMessage("Please fill in all fields correctly");

                } else {

                    //everything is g - start creating account
                    CreateUserAccount(email, name, password);

                }


            }
        });

    }

    private void CreateUserAccount(String email, final String name, String password) {

        //method to create user account with specific email and password
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //user account created successfully
                            showMessage("Account Created!");

                            //after we create an account we need to update their name (/other info if needed)
                            UpdateUserInfo(name, mAuth.getCurrentUser());

                        } else {

                            //account not successfully created
                            showMessage("account creation error" + task.getException().getMessage());
                        }
                    }
                });
    }

    //update user info (ONLY NAME ATM)
    private void UpdateUserInfo(String name, FirebaseUser currentUser) {
        //StorageReference mStorage = FirebaseStorage.getInstance().getReference().child();

        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        currentUser.updateProfile(profileUpdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //user info was updated successfully
                            showMessage("Registration Complete");

                            //take user to home activity
                            Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(homeActivity);
                            finish();
                        }
                    }
                });
    }

    //toast messages method
    private void showMessage(String s) {

        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

    }

    //see if email is valid
    public static boolean isValidEmail(String email) {
        {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
        }
    }
}