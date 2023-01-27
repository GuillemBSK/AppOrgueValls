package com.example.orguevalls;

import static com.example.orguevalls.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PreguntaSpinner extends Activity implements View.OnClickListener {

    public static int indexPreguntaActual; //variable que heredarà el valor (int) de la pregunta en la que estem.
    ImageView img;
    TextView text;
    ImageButton botoInfo;
    String spinnerValue;
    int puntuacio;
    int errors;
    TextView num_encerts;
    TextView num_errors;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.pregunta_spinner);

        puntuacio = Pregunta.puntuacio;
        errors = Pregunta.errors;

        num_encerts = findViewById(id.num_encerts_spinner);
        num_errors = findViewById(id.num_errors_spinner);

        num_encerts.setText(""+puntuacio);
        num_errors.setText(""+errors);

        //Carreguem la pregunta.

        String[] arraySpinner = Opcions.spinnerChoices[indexPreguntaActual];

        //Carreguem l'imatge.

        img = findViewById(R.id.img_spinner);
        img.setImageResource(Opcions.images[indexPreguntaActual]);

        //Carreguem la pregunta.

        text = findViewById(R.id.preguntaSpinner);
        text.setText(Opcions.question[indexPreguntaActual]);

        botoInfo = findViewById(R.id.infoSpinner);


        //Definim el Spinner del layout.

        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                spinnerValue = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerValue = parent.getItemAtPosition(0).toString();
            }
        });

        Button btn_seguent = findViewById(id.btn_seguent);
        btn_seguent.setOnClickListener(this);

        botoInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Informacio.indexPreguntaActual = indexPreguntaActual;
                Intent intent = new Intent(PreguntaSpinner.this, Informacio.class);
                startActivityForResult(intent,0);

            }
        });
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),spinnerValue, Toast.LENGTH_SHORT).show();

        if(spinnerValue==Opcions.spinnerAnswers[indexPreguntaActual]){
            Pregunta.puntuacio++;
            Pregunta.errors = errors;
            finish();  //Següent pregunta;
        }else{
            Pregunta.errors++;
            errors++;
            num_errors.setText(""+Pregunta.errors);
        }

    }
}
