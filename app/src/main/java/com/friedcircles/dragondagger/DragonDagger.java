package com.friedcircles.dragondagger;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.EditText;
import java.io.IOException;


public class DragonDagger extends AppCompatActivity implements View.OnTouchListener {

    MediaPlayer switchsound;

    MediaPlayer noteG;
    MediaPlayer noteF;
    MediaPlayer noteD;
    MediaPlayer noteA;

    MediaPlayer chordAC;
    MediaPlayer chordGBb;
    MediaPlayer chordFA;

    Boolean changeSet;

    Button b1, b2, b3, bhelp;

    Boolean fourthkey1 = false;
    Boolean fourthkey3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.splashScreen);

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dragon_dagger);


        changeSet = true;

        switchsound = MediaPlayer.create(this, R.raw.switchsounds);

        noteG = MediaPlayer.create(this, R.raw.g);
        noteF = MediaPlayer.create(this, R.raw.f);
        noteD = MediaPlayer.create(this, R.raw.d);
        noteA = MediaPlayer.create(this, R.raw.a);

        chordAC = MediaPlayer.create(this, R.raw.ac);
        chordGBb = MediaPlayer.create(this, R.raw.gbb);
        chordFA = MediaPlayer.create(this, R.raw.fa);


        b1 = (Button)findViewById(R.id.btnNote1);
        b2 = (Button)findViewById(R.id.btnNote2);
        b3 = (Button)findViewById(R.id.btnNote3);
//        bswitch = (Button)findViewById(R.id.btnSwitch);

        b1.setOnTouchListener(this);
        b2.setOnTouchListener(this);
        b3.setOnTouchListener(this);
//        bswitch.setOnTouchListener(this);

        bhelp = (Button)findViewById(R.id.btnHelp);

    }


    @Override
    public boolean onTouch(View v, MotionEvent ev){
        int action = ev.getAction();

        switch(action) {
            case (MotionEvent.ACTION_DOWN): {

                if (v.getId() == R.id.btnNote1) {
                    fourthkey1 = true;
                    b1.setBackgroundResource(R.drawable.button1_pressed);
                    if (changeSet) {
//                        noteG.seekTo(0);
//                        noteG.start();
                        noteA.start();
                    } else {
                        chordAC.start();
                    }
                }
                if (v.getId() == R.id.btnNote2) {
//                    fourthkey1 = true;
                    b2.setBackgroundResource(R.drawable.button1_pressed);
                    if (changeSet) {
//                        noteF.seekTo(0);
//                        noteF.start();
                        noteG.start();
                    }
                    else {
                        chordGBb.start();
                    }
                }
                if (v.getId() == R.id.btnNote3) {
                    fourthkey3 = true;
                    b3.setBackgroundResource(R.drawable.button1_pressed);
                    if (changeSet) {
                        noteD.start();
                    }
                    else {
                        chordFA.start();
                    }
                }

                if (fourthkey1 & fourthkey3 & changeSet) {
//                    noteF.pause();
                    noteA.pause();
                    noteD.pause();
//                    noteA.seekTo(0);
//                    noteA.start();
                    noteF.start();
                }

            }
            break;
            case MotionEvent.ACTION_UP:{

                if (fourthkey1 & fourthkey3) {
//                    noteA.pause();
                    noteF.pause();
                    noteF.seekTo(0);
                    fourthkey1 = false;
                    fourthkey3 = false;
                }

                if (v.getId() == R.id.btnNote1) {
                    fourthkey1 = false;
                    b1.setBackgroundResource(R.drawable.button1_unpressed);
                    if (changeSet) {
                        noteA.pause();
                        noteA.seekTo(0);
                    } else {
                        chordAC.pause();
                        chordAC.seekTo(0);
                    }

                }
                if (v.getId() == R.id.btnNote2) {
                    b2.setBackgroundResource(R.drawable.button1_unpressed);
                    if (changeSet) {
                        noteG.pause();
                        noteG.seekTo(0);
                    } else {
                        chordGBb.pause();
                        chordGBb.seekTo(0);
                    }
                }
                if (v.getId() == R.id.btnNote3) {
                    fourthkey3 = false;
                    b3.setBackgroundResource(R.drawable.button1_unpressed);
                    if (changeSet) {
                        noteD.pause();
                        noteD.seekTo(0);
                    } else {
                        chordFA.pause();
                        chordFA.seekTo(0);
                    }
                }
            }
            break;
        }
        return true;
    }


    public void switchSound(View view){

        switchsound.start();

        if(changeSet){
            changeSet = false;
        }   else {
            changeSet = true;
        }
    }

    public void gotoHelp(View v){
        Intent intent = new Intent(DragonDagger.this, HelpScreen.class);
        startActivity(intent);
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