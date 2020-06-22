package com.example.musicguessinggametest10;

import android.widget.TextView;

public class KeepUserScore extends FirstGuessScreen {
    // Probably need to initialize constructors
    private TextView scoreOfPlayer;
    private TextView displayScore;
    private String score;

    public void userScore()
    {
        FirstGuessScreen firstGuessScreen  = new FirstGuessScreen();

        //int playerScore = 0;
        int correctNumberGuesses = 0;
        boolean playerGuess = true;

        // Displays and adds score each time for correct answer and keeps track of the player's score
        while (playerGuess){
            firstGuessScreen.playerScore++;
            playerScore++;
            displayScore = (TextView) findViewById(R.id.displayScore);
            score = getIntent().getExtras().get("score").toString();
            displayScore.setText(String.format("Score = %d", playerScore));
            //++playerScore;
           // System.out.println("Testing this out woo");
        }


        // not sure if this increment is needed or not




    }

}


