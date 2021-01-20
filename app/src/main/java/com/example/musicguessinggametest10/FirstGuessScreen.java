package com.example.musicguessinggametest10;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class FirstGuessScreen extends AppCompatActivity { //implements  LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, View.OnCreateContextMenuListener, ComponentCallbacks2, LifecycleOwner, KeyEventDispatcher.Component, ViewModelStoreOwner, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator, AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {

    public TextView txvResult;

    public MediaPlayer mp;

    int startMusicFrom = 0;
    int endMusicAt = 30000;
    int length;
    int playerScore = 0;
    String playerGuess;
    ImageView speakButton;
    Context context;
    // View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_guess_screen);

//        Intent testingOne = new Intent(FirstGuessScreen.this, SecondGuessScreen.class);
//        startActivityForResult(testingOne, 1);

        txvResult = (TextView) findViewById(R.id.txvResult);
        speakButton = findViewById(R.id.btnSpeak);


        stopPlaying();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.song);
        mp.start();

    }


    public void getSpeechInput(View view) {

//
        if (speakButton.isPressed()) {
            mp.pause();
            length = mp.getCurrentPosition();
//        } else {
//            mp.start();
//            mp.seekTo(length);
//
//        }
        }



        switch (view.getId()) {
            case R.id.btnSpeak:

                Intent intentOne = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());


                //if (intentOne.resolveActivity(getPackageManager()) != null) {
                // the below startActivityForResult method is a crucial part of the speech validation.
                // Deleting it turns the mic button to just a pause button.

                //} else {
                //Toast.makeText(this, "You Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();

                startActivityForResult(intentOne, 1);

                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        AnswerCheck checkAnswer = new AnswerCheck();
        super.onActivityResult(requestCode, resultCode, data);
        voiceAnswerValidation(requestCode, resultCode, data);
        checkAnswer.answerCheck("Demi Lovato", txvResult);


//        if (requestCode == 10){
//
//            if (resultCode == RESULT_OK){
//
//                // MESS WITH THIS. THIS COULD BE THE ANSWER!!
//
//            }
//        }

    }


    public void voiceAnswerValidation(int requestCode, int resultCode, Intent data) {
        // mediaplayer.start is pivotal for the pause microphone button functionality.

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    assert result != null;
                    txvResult.setText(result.get(0));

                    // Extracted commented lines above to answerCheck method
                    // Extracted method works here
                }
                break;
        }
    }



//                if (txvResult.getText().equals(songName + "")) {
//                    playerScore = playerScore + 1;
//                  //  mediaPlayer.stop();
//                    Intent nextScreenTwo = new Intent(getApplicationContext(), SecondGuessScreen.class);
//                    nextScreenTwo.putExtra("score", playerScore);
//                    startActivityForResult(nextScreenTwo, 10);
//
//                }
        //  musicPauseTouch(btnSpeak, mediaPlayer);



    public void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;

        }
    }
}





