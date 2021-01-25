package com.example.musicguessinggametest10;

import android.widget.TextView;

public class AnswerCheck {

    FirstGuessScreen FGS = new FirstGuessScreen();

    public boolean isAnswerCheckWorking = false;


    public boolean answerCheck(String songName, TextView txvResult) {

        if (txvResult.getText().equals(songName)) // leaving out the "" after songName
        {

        isAnswerCheckWorking = true;
//            FGS.showToastMethod()
            FGS.stopPlaying();
            FGS.stopPlaying();
            // startActivity(nextScreenTwo);
           FGS.stopPlaying();

        } else {

        }


        return isAnswerCheckWorking;
    }

//    public static void showToastMethod(Context context, String message) {
//        Toast.makeText(context, "mymessage ", Toast.LENGTH_SHORT).show();
//    }

}
