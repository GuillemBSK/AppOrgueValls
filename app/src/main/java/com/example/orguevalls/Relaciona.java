package com.example.orguevalls;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Relaciona extends AppCompatActivity
{
    public int[] esCorrecte = new int[]{-1,-1,-1,-1};

    public String[] opcionsSpinner = new String[]
    {
        "Té només un teclat però ja té dimensions considerables",
        "Es porta a sobre mentre es toca",
        "Es pot posar a diferents llocs",
        "Té milers de tubs i necessita un espai gran per a posar-lo"
    };

    public String[] respostesCorrectes = new String[]
    {
            "Té milers de tubs i necessita un espai gran per a posar-lo",
            "Es porta a sobre mentre es toca",
            "Es pot posar a diferents llocs",
            "Té només un teclat però ja té dimensions considerables"
    };

    public Spinner dropdown1, dropdown2, dropdown3, dropdown4;

    public Button btnSeguent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relaciona);
        getSupportActionBar().hide();

        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        ImageView img4 = findViewById(R.id.img4);

        img1.setImageResource(R.drawable.portatiu);
        img2.setImageResource(R.drawable.positiu);
        img3.setImageResource(R.drawable.principal);
        img4.setImageResource(R.drawable.granorgue);

        dropdown1 = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);
        dropdown3 = findViewById(R.id.spinner3);
        dropdown4 = findViewById(R.id.spinner4);
        btnSeguent = findViewById(R.id.btn_seguent);

        ArrayAdapter<String> adapterView1 = new ArrayAdapter<String>
        (
            this,
            android.R.layout.simple_spinner_item, opcionsSpinner
        );
        adapterView1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapterView1);
        dropdown2.setAdapter(adapterView1);
        dropdown3.setAdapter(adapterView1);
        dropdown4.setAdapter(adapterView1);

        btnSeguent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                comprovaRespostes();
            }
        });
    }


    @SuppressWarnings({"ConstantConditions", "UnusedAssignment"})
    private void comprovaRespostes()
    {
        if(dropdown1.getSelectedItem().toString().equals(respostesCorrectes[0])) {
            esCorrecte[0] = 1;
        }
        else esCorrecte[0] = 0;
        if(dropdown2.getSelectedItem().toString().equals(respostesCorrectes[1])) {
            esCorrecte[1] = 1;
        }
        else esCorrecte[1] = 0;
        if(dropdown3.getSelectedItem().toString().equals(respostesCorrectes[2])) {
            esCorrecte[2] = 1;
        }
        else esCorrecte[2] = 0;
        if(dropdown4.getSelectedItem().toString().equals(respostesCorrectes[3])) {
            esCorrecte[3] = 1;
        }
        else esCorrecte[3] = 0;

        if(dropdown1.getSelectedItem().toString().equals(respostesCorrectes[0])
                && dropdown2.getSelectedItem().toString().equals(respostesCorrectes[1])
                && dropdown3.getSelectedItem().toString().equals(respostesCorrectes[2])
                && dropdown4.getSelectedItem().toString().equals(respostesCorrectes[3]))
        {
            Pregunta.puntuacio++;
            finish();
        }else{
            Pregunta.errors++;
        }
    }

}
