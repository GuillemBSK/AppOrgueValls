package com.example.orguevalls;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class CantatesOrgue extends AppCompatActivity {

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
                soundpool.play(soundId, 1, 1, 1, 0, 1);
            }
        });
    }




}