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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Activity_Configuration extends AppCompatActivity {

    private Button back;
    private Spinner spinner;
    private int mode;
    private String user;
    RadioGroup numPregs;
    private int numPreguntas;
    private RoomUsersDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_configuration);

        database = RoomUsersDB.getInstance(this);

        Intent intent = getIntent();
        user = intent.getStringExtra("User").toString().trim();

        mode = intent.getIntExtra("Gamemode", 0);
        numPreguntas = intent.getIntExtra("numPregs", 0);


        spinner = (Spinner) findViewById(R.id.spinnerMode);
        String[] gamemode = new String[]{"Preguntas Texto", "Preguntas Imágenes", "Preguntas Multimedia"};
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item,gamemode));
        spinner.setSelection(mode);

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

        back = (Button) findViewById(R.id.buttonExit);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ OpenMenu();}
        });

        numPregs = (RadioGroup) findViewById(R.id.numPreguntas);
        RadioButton aux = (RadioButton) numPregs.getChildAt(numPreguntas);
        aux.setChecked(true);
        numPregs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int buttonChecked) {
                RadioButton checked = radioGroup.findViewById(buttonChecked);
                numPreguntas = radioGroup.indexOfChild(checked);
            }
        });

    }

    public void OpenMenu(){
        if(!user.equals("Steve")) {
            database.mainDao().updateQuizType(user, mode);
            database.mainDao().updateNumPregs(user, numPreguntas);
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("User", user);
        intent.putExtra("Gamemode",mode);
        intent.putExtra("numPregs",numPreguntas);

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