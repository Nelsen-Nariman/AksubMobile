package com.example.aksubmobilepertemuan5.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aksubmobilepertemuan5.R;
import com.example.aksubmobilepertemuan5.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    TextView loginLink;
    Button registerButton;
    EditText usernameField, emailField, phoneNumberField, passwordField, confirmPasswordField;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance(getResources().getString(R.string.FIREBASE_URL));

        usernameField = findViewById(R.id.et_username);
        emailField = findViewById(R.id.et_email);
        phoneNumberField = findViewById(R.id.et_phone);
        passwordField = findViewById(R.id.et_password);
        confirmPasswordField = findViewById(R.id.et_confirm_password);

        registerButton = findViewById(R.id.register_btn);
        loginLink = findViewById(R.id.tv_login_link);

        loginLink.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });

        registerButton.setOnClickListener(v -> {
            String username = usernameField.getText().toString();
            String email = emailField.getText().toString();
            String phoneNumber = phoneNumberField.getText().toString();
            String password = passwordField.getText().toString();
            String confirmPassword = confirmPasswordField.getText().toString();

            if(username.length() < 5){
                Toast.makeText(this, "Username must be longer than 5 characters", Toast.LENGTH_SHORT).show();
            }else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                Toast.makeText(this, "Email must be valid", Toast.LENGTH_SHORT).show();
            }else if(password.length() < 8){
                Toast.makeText(this, "Password must be longer than 8 characters", Toast.LENGTH_SHORT).show();
            }else if(!password.equals(confirmPassword)){
                Toast.makeText(this, "Password must match Confirm Password", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    userRef = firebaseDatabase.getReference("users").child(mAuth.getCurrentUser().getUid());
                    userRef.setValue(new User(username, email, phoneNumber));
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                });
            }
        });
    }
}