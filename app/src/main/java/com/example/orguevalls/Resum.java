package com.example.orguevalls;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Resum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resum);
        getSupportActionBar().hide();
    }
}