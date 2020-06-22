package com.example.musicguessinggametest10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int startMusicFrom = 0;
    int endMusicAt = 30000;

//    MediaPlayer mediaPlayer;
//
//    Runnable stopMusicPlayer = new Runnable() {
//        @Override
//        public void run() {
//            mediaPlayer.pause();
//        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        Button startGameBtn = (Button) findViewById(R.id.startGameBtn);
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View startBtn) {
                Intent nextScreen = new Intent(getApplicationContext(), FirstGuessScreen.class);
//                mediaPlayer.start();
//                FirstGuessScreen firstGuessScreen = new FirstGuessScreen();
//                Handler handler = new Handler();
//                handler.postDelayed(stopMusicPlayer, endMusicAt);
                startActivity(nextScreen);
            }
        });


    }
}

//    public void stopMusicPlayer() {
//        mediaPlayer.stop();
//    }
//}

//        public void stopPlaying(){
//            FirstGuessScreen firstGuessScreen = new FirstGuessScreen();
//            if (firstGuessScreen.btnSpeak.isPressed()) {
//
//            }
//        }




//    public void stopMusicPlayer() {
//        Handler handler = new Handler();
//        handler.postDelayed(stopMusicPlayer, endMusicAt);
//    }
//}
