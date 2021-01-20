package com.example.musicguessinggametest10;

import android.content.Intent;
import android.widget.TextView;

public class AnswerCheck {

    FirstGuessScreen FGS = new FirstGuessScreen();

    protected void answerCheck(String songName, TextView txvResult) {

        if (txvResult.getText().equals(songName + "")) // leaving out the "" after songName
        {

           // Toast.makeText(this.FGS, "Correct!", Toast.LENGTH_SHORT).show();
            FGS.stopPlaying();

//            if (songName.length() >= 1){
//                songName.isEmpty();
//            }

            Intent intent = new Intent(this.FGS ,MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            FGS.startActivity(intent);

//            Intent testingOne = new Intent(FGS.getApplicationContext(), SecondGuessScreen.class);
//            FGS.startActivityForResult(testingOne, 1);
//            FGS.finish();

//            Intent nextScreenTwo = new Intent(getApplicationContext(), SecondGuessScreen.class);
//            nextScreenTwo.putExtra("score", playerScore);
            //               if (txvResult.getText().equals(songName + "")) {

            FGS.stopPlaying();

            // startActivity(nextScreenTwo);
           FGS.stopPlaying();

     //   } else {

          //  Toast.makeText(this.FGS, "Please Try again!", Toast.LENGTH_SHORT).show();
        }



    }
}
