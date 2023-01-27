package com.example.orguevalls;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Informacio extends AppCompatActivity implements View.OnClickListener{

    static int indexPreguntaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacio);
        getSupportActionBar().hide();

        //Omplim la informació segons el numero de pregunta.

        TextView info1 = findViewById(R.id.info1);
        TextView info2 = findViewById(R.id.info2);
        TextView info3 = findViewById(R.id.info3);
        TextView info4 = findViewById(R.id.info4);
        TextView info5 = findViewById(R.id.info5);

        info1.setText(Opcions.info[indexPreguntaActual][0]);
        info2.setText(Opcions.info[indexPreguntaActual][1]);
        info3.setText(Opcions.info[indexPreguntaActual][2]);
        info4.setText(Opcions.info[indexPreguntaActual][3]);
        info5.setText(Opcions.info[indexPreguntaActual][4]);

        //Botó pregunta següent.

        Button btn_enrere_informacio = findViewById(R.id.btn_enrere_informacio);
        btn_enrere_informacio.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish(); //Tornem a la pregunta (Sense perdre les dades.)
    }
}