package com.example.orguevalls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Resum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resum);
        getSupportActionBar().hide();
    }
}