package com.example.musicguessinggametest10;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class FirstGuessScreen extends AppCompatActivity {

    private TextView txvResult;
    MediaPlayer mediaPlayer;
    int startMusicFrom = 0;
    int endMusicAt = 30000;
    int playerScore = 0;
    String playerGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_guess_screen);
        txvResult = (TextView) findViewById(R.id.txvResult);
        final ImageView btnSpeak = (ImageView) findViewById(R.id.btnSpeak);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
        mediaPlayer.start();

        Handler handler = new Handler();
        // handler.postDelayed(stopMusicPlayer, endMusicAt);


        btnSpeak.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (btnSpeak.isPressed()) {
                    mediaPlayer.pause();
                }
                return false;
            }
        });

    }

   // deleted View view parameters from getSpeechInput
    public void getSpeechInput(View view) {

        getUserSpeech();

    }

    public void getUserSpeech() {
        Intent intentOne = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
       if (intentOne.resolveActivity(getPackageManager()) != null) {
        // the below startActivityForResult method is a crucial part of the speech validation.
        // Deleting it turns the mic button to just a pause button.
            startActivityForResult(intentOne, 10);
        } else {
            Toast.makeText(this, "You Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // KeepUserScore keepUserScore = new KeepUserScore();
        // mediaplayer.start is pivotal for the pause microphone button functionality.
        mediaPlayer.start();


        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    assert result != null;
                    txvResult.setText(result.get(0));
//                    if (txvResult.getText().equals("Demi Lovato")) {
////                        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
////                        mediaPlayer.stop();
////                        if (txvResult.getText().equals("Demi Lovato")) {
////                            playerScore = playerScore + 1;
////                        }
                    answerCheck("Demi Lovato");
                    // Extracted commented lines above to answerCheck method
                    // Extracted method works here
                    // answerCheck("Demi Lovato");


                    // Testing score keeping capabilities on line below
//
//                    } else {
//                        Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show();
//                    }
                    // break was here before I think
                }
                break;


        }
    }


        public void answerCheck (String songName){
            if (txvResult.getText().equals(songName + "")) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                if (txvResult.getText().equals(songName + "")) {
                    playerScore = playerScore + 1;

                    Intent nextScreenTwo = new Intent(getApplicationContext(), SecondGuessScreen.class);
                    nextScreenTwo.putExtra("score", playerScore);
                    startActivityForResult(nextScreenTwo, 10);
                }

            } else {
                Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show();
            }

            Runnable stopMusicPlayer = new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.pause();
                }
            };
        }
    }

    // Not sure if this method is needed here or not.
//    public void getSpeechInput() {
//
//        Intent intentOne = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        if (intentOne.resolveActivity(getPackageManager()) != null){
//            startActivityForResult(intentOne,10);
//        } else {
//            Toast.makeText(this, "You Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//    }


