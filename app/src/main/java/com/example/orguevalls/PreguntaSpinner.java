package com.example.orguevalls;

import static com.example.orguevalls.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PreguntaSpinner extends Activity implements View.OnClickListener {

    public static int indexPreguntaActual;
    ImageView img;
    TextView text;
    ImageButton botoInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.pregunta_spinner);

        String[] arraySpinner = Opcions.spinnerChoices[indexPreguntaActual];

        img = findViewById(R.id.img_spinner);
        img.setImageResource(Opcions.images[indexPreguntaActual]);

        text = findViewById(R.id.preguntaSpinner);
        text.setText(Opcions.question[indexPreguntaActual]);

        botoInfo = findViewById(R.id.infoSpinner);

        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

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
        finish();
    }
}
