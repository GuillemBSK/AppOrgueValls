package com.example.orguevalls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Historia extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historia);
        getSupportActionBar().hide();

        // Creem el botó per tornar al menú principal.
        Button btn_inici = findViewById(R.id.btn_enrere_historia);
        btn_inici.setOnClickListener(this);
    }

    public void onClick(View view) {
        finish(); //Tornem a la pregunta (Sense perdre les dades.)
    }
}
