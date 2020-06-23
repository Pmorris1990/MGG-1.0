package com.example.musicguessinggametest10;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondGuessScreen extends AppCompatActivity {

    private TextView displayScore;
    private String score;
    MediaPlayer mediaPlayer;

    FirstGuessScreen firstGuessScreen = new FirstGuessScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_guess_screen);
        FirstGuessScreen firstGuessScreen = new FirstGuessScreen();
        //firstGuessScreen.getUserSpeech();
       // firstGuessScreen.answerCheck("Hello");

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        // Referencing these methods below from FirstGuessScreen
        // throws NullPointerException errors. Must fix this sheet.


         // firstGuessScreen.answerCheck("Rick");

        displayScore = (TextView) findViewById(R.id.displayScore);

        score = getIntent().getExtras().get("score").toString();

        displayScore.setText("Score = " + score);

        // Not sure if getSpeechInput method will work here.
//        firstGuessScreen.getSpeechInput();

        // This make work throughout though.
        // Problem child below. Figure it out mate...
        // firstGuessScreen.answerCheck("Allen");

    }



}