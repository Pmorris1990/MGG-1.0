package com.example.musicguessinggametest10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView btnSpeak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpeak = (ImageView) findViewById(R.id.btnSpeak);
        Button startGameBtn = (Button) findViewById(R.id.startGameBtn);
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View startBtn) {
                Intent nextScreen = new Intent(getApplicationContext(), FirstGuessScreen.class);
                startActivity(nextScreen);
            }
        });
    }
}

