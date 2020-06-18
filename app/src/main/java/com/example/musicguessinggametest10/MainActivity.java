package com.example.musicguessinggametest10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    int startMusicFrom = 0;
    int endMusicAt = 30000;

    MediaPlayer mediaPlayer;

    Runnable stopMusicPlayer = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.pause();
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        Button startGameBtn = (Button) findViewById(R.id.startGameBtn);
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), FirstGuessScreen.class);
                mediaPlayer.start();
                Handler handler = new Handler();
                handler.postDelayed(stopMusicPlayer, endMusicAt);
                startActivity(nextScreen);
            }
        });


    }
}
