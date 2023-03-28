package com.example.orguevalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resum extends AppCompatActivity {

    private String encerts = String.valueOf(Pregunta.puntuacio);
    private String errors = String.valueOf(Pregunta.errors);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resum);
        getSupportActionBar().hide();

        TextView txtEncerts = findViewById(R.id.encerts_resum);
        TextView txtErrors = findViewById(R.id.errors_resum);
        Button btnInici = findViewById(R.id.btn_inici);

        txtEncerts.setText(encerts);
        txtErrors.setText(errors);

        btnInici.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Pregunta.errors = 0;
                Pregunta.puntuacio = 0;
                Pregunta.indexPreguntaActual = 0;
                MainActivity.music.stop();
                Intent intent = new Intent(Resum.this, MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }
}