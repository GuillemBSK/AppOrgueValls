package com.example.orguevalls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Historia extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historia);
        getSupportActionBar().hide();
    }
}
