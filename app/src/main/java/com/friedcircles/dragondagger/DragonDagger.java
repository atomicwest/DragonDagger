package com.friedcircles.dragondagger;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DragonDagger extends AppCompatActivity {

    MediaPlayer switchsound;

    MediaPlayer note1;
    MediaPlayer note2;
    MediaPlayer note3;

    MediaPlayer note1Aux;
    MediaPlayer note2Aux;
    MediaPlayer note3Aux;

    Boolean changeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon_dagger);

        changeSet = Boolean.FALSE;

        switchsound = MediaPlayer.create(this, R.raw.switchsounds);

        note1 = MediaPlayer.create(this, R.raw.lightsaberon2);
        note2 = MediaPlayer.create(this, R.raw.hit1);
        note3 = MediaPlayer.create(this, R.raw.hit2);

        note1Aux = MediaPlayer.create(this, R.raw.bcfire02);
        note2Aux = MediaPlayer.create(this, R.raw.concuss1);
        note3Aux = MediaPlayer.create(this, R.raw.concuss5);

        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }

    public void playnote1(View view){
        if(changeSet){
            note1.start();
        } else {
            note1Aux.start();
        }

    }

    public void playnote2(View view){
        if(changeSet){
            note2.start();
        } else {
            note2Aux.start();
        }
    }

    public void playnote3(View view){
        if(changeSet){
            note3.start();
        } else {
            note3Aux.start();
        }
    }


    public void switchSound(View view){

        switchsound.start();

        if(changeSet){
            changeSet = Boolean.FALSE;
        }   else {
            changeSet = Boolean.TRUE;
        }
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}