package com.friedcircles.dragondagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_help_screen);

    }

    public void backToMain(View v){
        Intent intent = new Intent(HelpScreen.this, DragonDagger.class);
        startActivity(intent);
    }

    public void nextHelp(View v){
        Intent intent = new Intent(HelpScreen.this, HelpPageNext.class);
        startActivity(intent);
    }

}
