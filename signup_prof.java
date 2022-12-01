package com.example.gestionstageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup_prof extends AppCompatActivity {
    private Button  btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btn= findViewById(R.id.button10);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_prof);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup_prof.this,loginProf.class));
            }
        });
    }
}