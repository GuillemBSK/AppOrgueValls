package com.example.orguevalls;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textRespostesCorrectes;
    String opcioSeleccionada = "";
    TextView pregunta;
    ImageView imatgePregunta;
    Button botoSubmit;
    ImageView topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight;
    int puntuacio = 0;
    int indexPreguntaActual = 0;
    String respostaSeleccionada = "";
    int numPreguntesTotals = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);
        getSupportActionBar().hide();


        pregunta = findViewById(R.id.pregunta);
        imatgePregunta = findViewById(R.id.img);
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

        //textRespostesCorrectes.setText("Respostes correctes: "+puntuacio);
        carregaNovaPregunta();

    }

    @Override
    public void onClick(View view) {
        ImageView imatgeSeleccionada = (ImageView) view;

        //Toast.makeText(getApplicationContext(),imatgeSeleccionada.toString(),Toast.LENGTH_SHORT).show();

        if(opcioSeleccionada.equals(Opcions.correctAnswers[indexPreguntaActual])){
            puntuacio++;
            indexPreguntaActual++;
            Toast.makeText(getApplicationContext(),"CORRECTE!",Toast.LENGTH_SHORT).show();
            carregaNovaPregunta();
        }else{
            Toast.makeText(getApplicationContext(),"NO ÉS CORRECTE!",Toast.LENGTH_SHORT).show();
        }
    }


    private void carregaNovaPregunta() {
        if(indexPreguntaActual == numPreguntesTotals){
            acabaTest();
            return;
        }

        pregunta.setText(Opcions.question[indexPreguntaActual]);
        imatgePregunta.setImageResource(Opcions.images[indexPreguntaActual]);

    }

    private void acabaTest() {
    }
}