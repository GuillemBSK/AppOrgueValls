package com.example.orguevalls;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CantatesOrgue extends AppCompatActivity {

    public int clicked = 0;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantates_orgue);
        getSupportActionBar().hide();

        Button btnPlay1;
        Button btnPlay2;
        Button btnPause;
        Button btnStop;
        TextView txtSongName;

        Button btn_play_1 = findViewById(R.id.btn_play_1);
        Button btn_play_2 = findViewById(R.id.btn_play_2);
        Button btn_pause = findViewById(R.id.btn_pause);
        Button btn_stop = findViewById(R.id.btn_stop);

        music = MediaPlayer.create(this, R.raw.snoring);

        btn_play_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startFirstSong();
                music.start();
            }
        });
        btn_play_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startSecondSong();
                music.start();
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                music.pause();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                stopMusic();
            }
        });


        Button btnEnrere = findViewById(R.id.btn_enrere_cantates);
        btnEnrere.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                music.stop();
                Intent switchIntent = new Intent(CantatesOrgue.this, MainActivity.class);
                startActivity(switchIntent);
            }
        });
    }

    public void stopMusic(){
        music.stop();
    }

    public void startFirstSong(){
        music = MediaPlayer.create(this, R.raw.snoring);
    }

    public void startSecondSong(){
        music = MediaPlayer.create(this, R.raw.snoring2);
    }
}