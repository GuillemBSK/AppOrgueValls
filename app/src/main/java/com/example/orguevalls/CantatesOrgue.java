package com.example.orguevalls;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CantatesOrgue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantates_orgue);
        getSupportActionBar().hide();

        SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        int soundId = soundPool.load(this, R.raw.snoring, 1);
        // soundId for reuse later on
        soundPool.play(soundId, 1, 1, 0, 1, 1);
    }
}