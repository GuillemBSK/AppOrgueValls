package com.example.orguevalls;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button btn_comenca = findViewById(R.id.btn_comenca);
        Button btn_cantates_orgue = findViewById(R.id.btn_cantates);
        Button btn_historia_orgue = findViewById(R.id.btn_historia_orgue);
        btn_comenca.setOnClickListener(this);

        btn_cantates_orgue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, CantatesOrgue.class);
                startActivityForResult(intent,0);
            }
        });

        btn_historia_orgue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Historia.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Pregunta.class);
        startActivityForResult(intent,0);
    }
}