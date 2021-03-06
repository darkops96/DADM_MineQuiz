package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button openQuiz, exit, ranking, btUser, config;
    private int mode;
    private String user;
    private TextView helloUser;
    RoomUsersDB database;
    private int numPregs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = 0;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        database = RoomUsersDB.getInstance(this);
        Intent intent = getIntent();
        user = intent.getStringExtra("User").toString().trim();
        mode = intent.getIntExtra("Gamemode", 0);
        numPregs = intent.getIntExtra("numPregs", 0);

        helloUser = (TextView) findViewById(R.id.helloUser);
        helloUser.setText("¡Hola "+user+"!");
        btUser = (Button) findViewById(R.id.bt_user);
        btUser.setText(user);

        openQuiz = (Button) findViewById(R.id.buttonQuiz);
        openQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenQuiz();
            }
        });

        exit = (Button) findViewById(R.id.buttonExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        config = (Button) findViewById(R.id.button_Config);
        config.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                OpenConfig();
            }
        });
        ranking = (Button) findViewById(R.id.B_rank);
        ranking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ OpenRank();}
        });

        btUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRegister();
            }
        });
    }

    public void OpenQuiz(){

        if(!user.equals("Steve")) {
            database.mainDao().updateGames(user, database.mainDao().getTimes(user) + 1);
        }

        Intent intent = new Intent(this, Activity_Quiz.class);
        intent.putExtra("Gamemode", mode);
        intent.putExtra("User", user);
        intent.putExtra("numPregs", numPregs);
        startActivity(intent);
        finish();
    }
    public void OpenRank(){
        Intent intent = new Intent(this, Activity_Ranking.class);
        intent.putExtra("User", user);
        startActivity(intent);
        finish();
    }

    public void OpenRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
    public void OpenConfig(){
        Intent intent = new Intent(this, Activity_Configuration.class);
        intent.putExtra("Gamemode", mode);
        intent.putExtra("numPregs", numPregs);
        intent.putExtra("User", user);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE);
            }
            else {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }
}