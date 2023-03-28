package com.example.orguevalls;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences prefs;
    public static MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean buttonSound = prefs.getBoolean("buttonSound", false);
        boolean buttonMusic = prefs.getBoolean("buttonMusic", false);




        music = MediaPlayer.create(this, R.raw.background);
        music.start();

        Button btn_comenca = findViewById(R.id.btn_comenca);
        Button btn_cantates_orgue = findViewById(R.id.btn_cantates);
        Button btn_historia_orgue = findViewById(R.id.btn_historia_orgue);
        Button btn_preferences = findViewById(R.id.btn_Preferences);
        btn_preferences.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Preferences.class);
                startActivityForResult(intent,0);
            }
        });

        btn_comenca.setOnClickListener(this);

        SoundPool soundpool = new SoundPool.Builder().build();
        int soundId = soundpool.load(this, R.raw.btnsound, 1);

        if (buttonMusic & buttonSound) {

        } else if (!buttonMusic) {
            music.stop();
        } else if (!buttonSound) {
            soundpool.pause(soundId);
        }

        btn_cantates_orgue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                music.stop();
                soundpool.play(soundId, 1, 1, 1, 0, 1);
                Intent intent = new Intent(MainActivity.this, CantatesOrgue.class);
                startActivityForResult(intent,0);
            }
        });

        btn_historia_orgue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                soundpool.play(soundId, 1, 1, 1, 0, 1);
                Intent intent = new Intent(MainActivity.this, Historia.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    public void onClick(View view) {
        SoundPool soundpool = new SoundPool.Builder().build();
        int soundId = soundpool.load(this, R.raw.btnsound, 1);
        soundpool.play(soundId, 1, 1, 1, 0, 1);
        Intent intent = new Intent(MainActivity.this, Pregunta.class);
        startActivityForResult(intent,0);
    }
}