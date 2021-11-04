package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button openQuiz, exit, ranking;
    private Spinner spinner;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = 0;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
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
                finish();
                System.exit(0);
            }
        });
        ranking = (Button) findViewById(R.id.B_rank);
        ranking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ OpenRank();}
        });
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] gamemode = new String[]{"Preguntas Texto", "Preguntas Imágenes"};
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item,gamemode));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mode = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mode = 0;
            }
        });
    }

    public void OpenQuiz(){
        Intent intent = new Intent(this, Activity_Quiz.class);
        intent.putExtra("Gamemode", mode);
        startActivity(intent);
        finish();
    }
    public void OpenRank(){
        Intent intent = new Intent(this, Activity_Ranking.class);
        startActivity(intent);
        finish();
    }

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