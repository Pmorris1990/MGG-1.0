package com.example.musicguessinggametest10;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondGuessScreen extends FirstGuessScreen {


//    private FirstGuessScreen firstGuessScreen;
    private TextView txvResult;
    private TextView displayScore;
  //  private String score;
 //   MediaPlayer mediaPlayer;
    private ImageView speakButton;
 //   Context context;
  //  Intent data;
 //   View view;
    Intent intentOne;
    int playerScore = 0;


//    public void setFirstGuessScreen(FirstGuessScreen firstGuessScreen) {
//        this.firstGuessScreen = firstGuessScreen;
//        firstGuessScreen.getSpeechInput();
//        firstGuessScreen.answerCheck("Hello");
//    }


    // SecondGuessScreen s2 = new SecondGuessScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_screen);

      //  FirstGuessScreen FGS = new FirstGuessScreen();

        txvResult = (TextView) findViewById(R.id.txvResult);
        speakButton = (ImageView) findViewById(R.id.btnSpeak);
        displayScore = (TextView) findViewById(R.id.displayScore);

        // Not confirmed to work

        stopPlaying();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.salad_days);
        mp.start();

//


            //firstGuessScreen.musicPauseTouch(btnSpeak, mediaPlayer);

     //   voiceAnswerValidation(2, 2, getIntent());
//        answerCheck("Mac Demarco", txvResult);
//        Intent nextScreen = new Intent(getApplicationContext(), ThirdGuessScreen.class);
//        nextScreen.putExtra("score", playerScore);
//        startActivityForResult(nextScreen, 10);
       // firstGuessScreen.voiceAnswerValidation(10, 10, data, mediaPlayer);
//        firstGuessScreen.getSpeechInput(this.btnSpeak);

        // Referencing these methods below from FirstGuessScreen
        // throws NullPointerException errors. Must fix this sheet.

        // firstGuessScreen.getUserSpeech();
        // firstGuessScreen.answerCheck("Hello");
        // firstGuessScreen.getSpeechInput(btnSpeak);

        // firstGuessScreen.answerCheck("Rick");

//        score = getIntent().getExtras().get("score").toString();
//
//        displayScore.setText("Score = " + score);

    }

    //

//    public void getSpeechInput(View view) {
//
//        if (speakButton.isPressed()) {
//            mp.pause();
//            length = mp.getCurrentPosition();
//        } else {
//            mp.start();
//            mp.seekTo(length);
//        }
//
//
//            switch (view.getId()) {
//                case R.id.btnSpeak:
//
//                    Intent intentOne = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//                    intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//                    intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//
//
//                    //if (intentOne.resolveActivity(getPackageManager()) != null) {
//                    // the below startActivityForResult method is a crucial part of the speech validation.
//                    // Deleting it turns the mic button to just a pause button.
//
//                    //} else {
//                    //Toast.makeText(this, "You Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();
//
//                    startActivityForResult(intentOne, 2);
//                    answerCheck("Mac Demarco", txvResult);
////                    Intent testingTwo = new Intent(SecondGuessScreen.this, ThirdGuessScreen.class);
////                    startActivityForResult(testingTwo, 1);
//                    break;
//            }
//        }
//

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            AnswerCheck checkAnswer = new AnswerCheck();
          //  FirstGuessScreen FGSTwo = new FirstGuessScreen();

            getSpeechInput(findViewById(R.id.txvResult));

            super.onActivityResult(requestCode, resultCode, data);
            voiceAnswerValidation(requestCode, resultCode, data);


            // Worried that inheriting from FirstGuessScreen keeps variable data of
            // the checkAnswer.answerCheck method below, even though it's an object of answerCheck...
            // I don't even know if what I just said is possible, but I feel like it is -_-
            checkAnswer.answerCheck("Mac DeMarco", txvResult);

            if (checkAnswer.isAnswerCheckWorking) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ThirdGuessScreen.class);
                startActivityForResult(intent, 2);
            } else {
                Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show();
            }

//            Intent intent = new Intent(this, ThirdGuessScreen.class);
//            startActivity(intent);

//            Intent testingTwo = new Intent(SecondGuessScreen.this, ThirdGuessScreen.class);
//            startActivityForResult(testingTwo, 2);


        }



}

