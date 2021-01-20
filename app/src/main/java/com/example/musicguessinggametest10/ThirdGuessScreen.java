package com.example.musicguessinggametest10;

import android.content.Intent;
import android.os.Bundle;

public class ThirdGuessScreen extends FirstGuessScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_screen);

        AnswerCheck checkAnswer = new AnswerCheck();

        checkAnswer.answerCheck("yeah", txvResult);
        Intent testingTwo = new Intent(ThirdGuessScreen.this, FirstGuessScreen.class);
        startActivityForResult(testingTwo, 4);


    }
}