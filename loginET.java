package com.example.gestionstageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginET extends AppCompatActivity implements  View.OnClickListener {
    private Button btn;

    EditText etLoginEmail;
    EditText etLoginPassword;
    Button tvRegisterHere;
    Button btnLogin;
    FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState)  {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etLoginEmail = findViewById(R.id.editTextTextPersonName);
        etLoginPassword = findViewById(R.id.editTextTextPersonName2);
        tvRegisterHere = findViewById(R.id.button9);
        btnLogin = findViewById(R.id.button7);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
        tvRegisterHere.setOnClickListener(view ->{
            startActivity(new Intent(loginET.this, signup.class));
        });
    }

    private void loginUser(){
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etLoginPassword.setError("Password cannot be empty");
            etLoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(loginET.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginET.this, MainActivity.class));
                    }else{
                        Toast.makeText(loginET.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        btn= findViewById(R.id.button9);
        btn.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        startActivity(new Intent(loginET.this, signup.class));
    }


}