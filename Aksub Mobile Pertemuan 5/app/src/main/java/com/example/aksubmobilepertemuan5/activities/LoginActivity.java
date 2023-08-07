package com.example.aksubmobilepertemuan5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aksubmobilepertemuan5.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    TextView registerLink;
    Button loginButton;
    EditText emailField, passwordField;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener = firebaseAuth -> {
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(authStateListener);

        emailField = findViewById(R.id.et_email);
        passwordField = findViewById(R.id.et_password);
        registerLink = findViewById(R.id.tv_register_link);
        loginButton = findViewById(R.id.login_btn);

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Email and Password must be filled", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show();
                    }else{
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }

        });
    }
}