package com.example.orguevalls;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CantatesOrgue extends AppCompatActivity {

    public int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantates_orgue);
        getSupportActionBar().hide();

        ImageButton play = findViewById(R.id.btn_play_cantates);

        SoundPool soundpool = new SoundPool.Builder().build();
        int soundId = soundpool.load(this, R.raw.snoring, 1);

        //TODO: Implementar reproductor completo (Play, pause, stop...)
        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (clicked == 0) {
                    soundpool.play(soundId, 1, 1, 1, 0, 1);
                    play.setBackground(getResources().getDrawable(R.drawable.volume_on));
                    clicked = 1;
                } else if (clicked == 1) {
                    soundpool.stop(soundId);
                    play.setBackground(getResources().getDrawable(R.drawable.volume_off));
                    clicked = 0;
                }
            }
        });

        Button btn_play = findViewById(R.id.btn_play);
        Button btn_pause = findViewById(R.id.btn_pause);
        Button btn_stop = findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                soundpool.play(soundId, 1, 1, 1, 0, 1);
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                soundpool.pause(soundId);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                soundpool.stop(soundId);
            }
        });



        Button btnEnrere = findViewById(R.id.btn_enrere_cantates);
        btnEnrere.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent switchIntent = new Intent(CantatesOrgue.this, MainActivity.class);
                startActivity(switchIntent);
            }
        });


    }




}