package com.example.musicguessinggametest10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondGuessScreen extends AppCompatActivity {

    private TextView displayScore;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_guess_screen);

        displayScore = (TextView) findViewById(R.id.displayScore);

        score = getIntent().getExtras().get("score").toString();

        displayScore.setText("Score = " + score);

    }
}