package com.example.orguevalls;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Pregunta extends AppCompatActivity implements View.OnClickListener{


    TextView pregunta;
    ImageView imatgePregunta;
    Button botoSubmit;
    ImageButton botoInfo;
    ImageView topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight;
    public static int puntuacio = 0;
    public static int errors = 0;
    static int indexPreguntaActual = 0;
    int numPreguntesTotals = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);
        getSupportActionBar().hide();

        //Assignem cada un dels elements del layout a una variable.

        pregunta = findViewById(R.id.preguntaSpinner);
        imatgePregunta = findViewById(R.id.img);
        botoInfo = findViewById(R.id.botoInfo);

        // Creem un botó per a cada imatge a triar.
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        middleLeft = findViewById(R.id.middle_left);
        middleRight = findViewById(R.id.middle_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);

        // Assignem un onClickListener a cada botó.
        topLeft.setOnClickListener(this);
        topRight.setOnClickListener(this);
        middleLeft.setOnClickListener(this);
        middleRight.setOnClickListener(this);
        bottomLeft.setOnClickListener(this);
        bottomRight.setOnClickListener(this);

        //Obrim el layout d'informació en cas de clicar el botó.

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

        if(id == element){  //Si l'id de la resposta seleccionada és igual al de la correcte sumem punts, i passem a la següent.
            sumaEncerts();
            indexPreguntaActual++;
            Toast.makeText(getApplicationContext(),"CORRECTE!",Toast.LENGTH_SHORT).show();
            carregaNovaPregunta();
        }else{
            sumaErrors();  //Si l'id de la resposta seleccionada és diferent al de la correcte sumem errors.
            Toast.makeText(getApplicationContext(),"INCORRECTE",Toast.LENGTH_SHORT).show();
        }
    }


    public void carregaNovaPregunta() {
        if(indexPreguntaActual == numPreguntesTotals){  //En cas de ser la última pregunta, carregem el layout de resum.
            acabaTest();
        }

        //Definim si és una pregunta és tipus Spinner segons l'índex.
        else if(indexPreguntaActual == 1 || indexPreguntaActual == 3 || indexPreguntaActual == 5 || indexPreguntaActual == 11){
            PreguntaSpinner.indexPreguntaActual = this.indexPreguntaActual;
            Intent intent = new Intent(Pregunta.this, PreguntaSpinner.class);
            startActivityForResult(intent,0);
            indexPreguntaActual++;
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }

        //Definim si és una pregunta és tipus Relaciona segons l'índex.
        else if(indexPreguntaActual == 7){
            PreguntaSpinner.indexPreguntaActual = this.indexPreguntaActual;
            Intent intent = new Intent(Pregunta.this, Relaciona.class);
            startActivity(intent);
            indexPreguntaActual++;
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }

        //Si no, carreguem una nova pregunta i imatge.
        else{
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }

        if(indexPreguntaActual == 12){
            Intent intent = new Intent(Pregunta.this, Resum.class);
            startActivityForResult(intent,0);
        }
    }

    private void sumaEncerts(){
        puntuacio++;
        TextView num_encerts = findViewById(R.id.num_encerts_spinner);
        num_encerts.setText(""+puntuacio);
    }

    private void sumaErrors(){
        errors++;
        TextView num_errors = findViewById(R.id.num_errors_spinner);
        num_errors.setText(""+errors);
    }

    //Obrim el resum (Layout que apareix al finalitzar el test.)
    private void acabaTest() {

        TextView num_encerts = findViewById(R.id.encerts_resum);
        TextView num_errors = findViewById(R.id.errors_resum);

        num_encerts.setText(""+puntuacio);
        num_errors.setText(""+errors);

        Intent intent = new Intent(Pregunta.this, Resum.class);
        startActivityForResult(intent,0);
    }

}