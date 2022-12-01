package com.example.gestionstageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginProf extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btn = findViewById(R.id.button7);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_prof);

       btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            startActivity(new Intent(loginProf.this,signup_prof.class));
        }
    });
}


}