package com.example.orguevalls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class Pregunta extends AppCompatActivity implements View.OnClickListener{


    TextView pregunta;
    ImageView imatgePregunta;
    Button botoSubmit;
    ImageButton botoInfo;
    ImageView topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight;
    TextView txtIdPregunta;
    int puntuacio = 0;
    int errors = 0;
    static int indexPreguntaActual = 0;
    int numPreguntesTotals = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);
        getSupportActionBar().hide();


        pregunta = findViewById(R.id.preguntaSpinner);
        imatgePregunta = findViewById(R.id.img);
        botoInfo = findViewById(R.id.botoInfo);
        txtIdPregunta = findViewById(R.id.num_pregunta);
        
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        middleLeft = findViewById(R.id.middle_left);
        middleRight = findViewById(R.id.middle_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        
        topLeft.setOnClickListener(this);
        topRight.setOnClickListener(this);
        middleLeft.setOnClickListener(this);
        middleRight.setOnClickListener(this);
        bottomLeft.setOnClickListener(this);
        bottomRight.setOnClickListener(this);



        botoInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Informacio.indexPreguntaActual = indexPreguntaActual;

                Intent intent = new Intent(Pregunta.this, Informacio.class);
                startActivityForResult(intent,0);


                }
        });

        carregaNovaPregunta();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId(); //Element seleccionat
        int element = Opcions.correctAnswers[indexPreguntaActual]; //Element resposta correcte.

        if(id == element){
            sumaEncerts();
            indexPreguntaActual++;
            Toast.makeText(getApplicationContext(),"CORRECTE!",Toast.LENGTH_SHORT).show();
            carregaNovaPregunta();
        }else{
            sumaErrors();
            Toast.makeText(getApplicationContext(),"INCORRECTE",Toast.LENGTH_SHORT).show();
        }
    }


    private void carregaNovaPregunta() {
        if(indexPreguntaActual == numPreguntesTotals){
            acabaTest();
        }

        else if(indexPreguntaActual == 1 || indexPreguntaActual == 3 || indexPreguntaActual == 5 || indexPreguntaActual == 7 || indexPreguntaActual == 11){
            PreguntaSpinner.indexPreguntaActual = this.indexPreguntaActual;
            Intent intent = new Intent(Pregunta.this, PreguntaSpinner.class);
            startActivityForResult(intent,0);
            indexPreguntaActual++;
            txtIdPregunta.setText(""+indexPreguntaActual);
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }

        else{
            txtIdPregunta.setText(""+indexPreguntaActual);
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }
    }

    private void sumaEncerts(){
        puntuacio++;
        TextView num_encerts = findViewById(R.id.num_encerts);
        num_encerts.setText(""+puntuacio);
    }

    private void sumaErrors(){
        errors++;
        TextView num_errors = findViewById(R.id.num_errors);
        num_errors.setText(""+errors);
    }

    private void obrirDialog(){
        Toast.makeText(getApplicationContext(),"INFO!",Toast.LENGTH_SHORT).show();
    }

    private void acabaTest() {

        TextView num_encerts = findViewById(R.id.encerts_resum);
        TextView num_errors = findViewById(R.id.errors_resum);

        num_encerts.setText(""+puntuacio);
        num_errors.setText(""+errors);

        Intent intent = new Intent(Pregunta.this, Resum.class);
        startActivityForResult(intent,0);
    }

    public static int getIndexPreguntaActual() {
        return indexPreguntaActual;
    }

}