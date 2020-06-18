package com.example.musicguessinggametest10;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class FirstGuessScreen extends AppCompatActivity {

    private TextView txvResult;
    //public ImageView btnSpeak;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_guess_screen);
        txvResult = (TextView) findViewById(R.id.txvResult);
      //  btnSpeak = (ImageView) findViewById(R.id.btnSpeak);

    }

    public void getSpeechInput(View view){

        Intent intentOne = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intentOne.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        if (intentOne.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intentOne,10);
        } else {
            Toast.makeText(this, "You Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();
        }


        MainActivity mainActivity = new MainActivity();

//        while (mainActivity.mediaPlayer.isPlaying()){
//
//        }
//        while (btnSpeak.isPressed()){
//            mainActivity.mediaPlayer.stop();
//        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final MainActivity mainActivity = new MainActivity();


        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    if (txvResult.getText().equals("Demi Lovato")) {
                        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                        Intent nextScreenTwo = new Intent(getApplicationContext(), SecondGuessScreen.class);
                        startActivityForResult(nextScreenTwo, 10);

                    }
                    else {
                        Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

        }


        }

    private void stopMusic() {
        //startActivity(nextScreenTwo);
        MainActivity mainActivity = new MainActivity();

    }
}

