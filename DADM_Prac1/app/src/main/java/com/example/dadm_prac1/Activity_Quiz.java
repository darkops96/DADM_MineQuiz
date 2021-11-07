package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentContainer;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_Quiz extends AppCompatActivity {

    private Button botonValidar;
    private int score, numPreg, mode;
    private FragmentContainerView myContainer;
    private boolean acierto, intermedio;
    private TextView scoreTV;
    private String user;
    private TextView timerText;

    //Room
    List<QuestionsData> questionsList = new ArrayList<>();
    public List<QuestionsData> textQuestionsList = new ArrayList<>();
    public List<QuestionsData> imageQuestionsList = new ArrayList<>();
    public List<QuestionsData> multimediaQuestionsList = new ArrayList<>();
    RoomQuestionsDB questionsDB;

    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    int finalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        timerText = (TextView) findViewById(R.id.timer);
        timer = new Timer();



        questionsDB = RoomQuestionsDB.getInstance(this);
        questionsList = questionsDB.questionsDao().getAll();

        for (QuestionsData question:questionsList)
        {
            if(question.getType()==0)
                textQuestionsList.add(question);
            if(question.getType()==1)
                imageQuestionsList.add(question);
            if(question.getType()==2)
                multimediaQuestionsList.add(question);
        }

        score = 0;
        scoreTV = (TextView) findViewById(R.id.scoreTV);
        scoreTV.setText("Puntuación: "+score * 100 + "        Aciertos: " + score);
        numPreg = 0;
        acierto = false;
        intermedio = false;
        Intent intent = getIntent();
        mode = intent.getIntExtra("Gamemode", -1);
        user = intent.getStringExtra("User").toString().trim();

        Fragment fragment;
        if(mode == 0){
            fragment = new Pregunta_Texto();
        }
        else if(mode==1){
            fragment = new Pregunta_Imagenes();
        }
        else{
            fragment = new Pregunta_Multimedia();
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();

        myContainer = (FragmentContainerView) findViewById(R.id.fragmentContainerView);
        botonValidar = (Button) findViewById(R.id.buttonValidate);
        botonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeQuestion();
            }
        });
        startTimer();
    }

    public void ChangeQuestion(){
        int maxPreg;

        if(mode == 0) {
            maxPreg = textQuestionsList.size();
        } else if(mode == 1) {
            maxPreg = imageQuestionsList.size();
        } else{
            maxPreg = multimediaQuestionsList.size();
        }

        if(numPreg<maxPreg-1)
        {
            Fragment fragment;
            if (acierto) {
                score++;
                scoreTV.setText("Puntuación: "+score * 100 + "       Aciertos: " + score);
            }
            numPreg++;
            if(mode == 0) {
                fragment = new Pregunta_Texto();
            } else if(mode ==1){
                fragment = new Pregunta_Imagenes();
            } else{
                fragment = new Pregunta_Multimedia();


            }
            acierto = false;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.fragmentContainerView, fragment);
            transaction.commit();
        }
        else
        {
            Intent intent = new Intent(this, Activity_Score.class);
            intent.putExtra("Score", (int) Math.round(score*100/finalTime));
            intent.putExtra("Gamemode", mode);
            intent.putExtra("User", user);
            startActivity(intent);
            finish();
        }
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public int getNumPreg(){
        return numPreg;
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
    private void startTimer(){
        timerTask = new TimerTask(){
            @Override
            public void run(){
                time++;
                timerText.setText(getTimerText());
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
    }
    private String getTimerText(){
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400)%3600)%60;
        int minutes = ((rounded%86400)%3600)/60;

        finalTime =  minutes*60 + seconds;
        return formatTime(seconds, minutes);
    }

    private String formatTime(int seconds, int minutes){
        return String.format("Time:  " + String.format("%02d",minutes)+":"+String.format("%02d",seconds));
    }
}