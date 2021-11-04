package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity_Score extends AppCompatActivity {

    private Button again, exitMenu;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        int score = intent.getIntExtra("Score", -1);
        mode = intent.getIntExtra("Gamemode", -1);
        TextView scorewT = findViewById(R.id.score);
        if(score == 1){
            scorewT.setText("¡Has obtenido\n"+score+" punto!");
        } else {
            scorewT.setText("¡Has obtenido\n"+score+" puntos!");
        }
        again = (Button) findViewById(R.id.B_Again);
        again.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ OpenQuiz();}
                                 });
        exitMenu = (Button)findViewById(R.id.B_Exit);
        exitMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){OpenMenu();}
        });
    }
    public void OpenQuiz(){
        Intent intent = new Intent(this, Activity_Quiz.class);
        intent.putExtra("Gamemode", mode);
        startActivity(intent);
        finish();
    }
    public void OpenMenu(){
        Intent intent = new Intent(this, MainActivity.class);
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