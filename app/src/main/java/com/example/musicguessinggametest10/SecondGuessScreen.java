package com.example.musicguessinggametest10;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondGuessScreen extends AppCompatActivity implements VoiceRecognition {

//    private FirstGuessScreen firstGuessScreen;
    private TextView txvResult;
    private TextView displayScore;
    private String score;
    MediaPlayer mediaPlayer;
    ImageView btnSpeak;
    View view;
    Context context;
    Intent intent;



//    public void setFirstGuessScreen(FirstGuessScreen firstGuessScreen) {
//        this.firstGuessScreen = firstGuessScreen;
//        firstGuessScreen.getSpeechInput();
//        firstGuessScreen.answerCheck("Hello");
//    }

    FirstGuessScreen firstGuessScreen = new FirstGuessScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_guess_screen);
        PackageManager packageManager = getPackageManager();

        txvResult = (TextView) findViewById(R.id.txvResult);
        btnSpeak = (ImageView) findViewById(R.id.btnSpeak);
        displayScore = (TextView) findViewById(R.id.displayScore);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.salad_days);
        mediaPlayer.start();




        // Not confirmed to work

        firstGuessScreen.musicPauseTouch(btnSpeak, mediaPlayer);

        firstGuessScreen.getSpeechInput(view);
        firstGuessScreen.answerCheck("Mac Demarco", txvResult, context);
//
//        firstGuessScreen.voiceAnswerValidation(10, 10, firstGuessScreen.getIntent() );
//        firstGuessScreen.answerCheck("Test");



        // setFirstGuessScreen(firstGuessScreen);


//         firstGuessScreen.pauseMusicOnTouch(null);
//         firstGuessScreen.getSpeechInput(null);


        // Referencing these methods below from FirstGuessScreen
        // throws NullPointerException errors. Must fix this sheet.

        // firstGuessScreen.getUserSpeech();
        // firstGuessScreen.answerCheck("Hello");
        // firstGuessScreen.getSpeechInput(btnSpeak);

        // firstGuessScreen.answerCheck("Rick");


//
//        score = getIntent().getExtras().get("score").toString();
//
//        displayScore.setText("Score = " + score);

        // Not sure if getSpeechInput method will work here.
//        firstGuessScreen.getSpeechInput();

        // This make work throughout though.
        // Problem child below. Figure it out mate...
        // firstGuessScreen.answerCheck("Allen");


//            btnSpeak.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    if (btnSpeak.isPressed()) {
//                        mediaPlayer.pause();
//                    }
//                    return false;
//                }
//            });
//        }


//    public void answerFunctions() {
//        firstGuessScreen.getUserSpeech();
//        firstGuessScreen.answerCheck("Mac Demarco");
//        // maybe add intents here?
//    }


//        public void setFirstGuessScreen (FirstGuessScreen firstGuessScreen){
//            this.firstGuessScreen = firstGuessScreen;
//        }
//
//        public FirstGuessScreen getFirstGuessScreen () {
//            return firstGuessScreen;
//        }


    }
}