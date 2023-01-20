package com.example.orguevalls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;


public class Pregunta extends AppCompatActivity implements View.OnClickListener{


    String opcioSeleccionada = "";
    TextView pregunta;
    ImageView imatgePregunta;
    Button botoSubmit;
    Button botoInfo;
    ImageView topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight;
    int puntuacio = 0;
    int errors = 0;
    int indexPreguntaActual = 0;
    int numPreguntesTotals = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);
        getSupportActionBar().hide();


        pregunta = findViewById(R.id.pregunta);
        imatgePregunta = findViewById(R.id.img);
        botoInfo = findViewById(R.id.btn_info);
        //botoSubmit = findViewById(R.id.ButtonSeguent);
        
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
                obrirDialog();
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
            return;
        }else{
            pregunta.setText(Opcions.question[indexPreguntaActual]);
            imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);
        }
    }

    private void sumaEncerts(){
        TextView num_encerts = findViewById(R.id.num_encerts);
        puntuacio++;
        num_encerts.setText(""+puntuacio);
    }

    private void sumaErrors(){
        TextView num_errors = findViewById(R.id.num_errors);
        errors++;
        num_errors.setText(""+errors);


    }

    private void obrirDialog(){
        Toast.makeText(getApplicationContext(),"INFO!",Toast.LENGTH_SHORT).show();
    }

    private void acabaTest() {
        //Llamar otro layout.
    }
}