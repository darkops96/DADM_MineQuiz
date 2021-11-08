package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private int numPreguntas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Intent intent = getIntent();
        user = intent.getStringExtra("User").toString().trim();
        mode = intent.getIntExtra("Gamemode", -1);
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] gamemode = new String[]{"Preguntas Texto", "Preguntas Imágenes", "Preguntas Multimedia"};
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
        back = (Button) findViewById(R.id.buttonExit);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ OpenMenu();}
        });
        numPreguntas=2;
        numPregs = (RadioGroup) findViewById(R.id.numPreguntas);

        numPregs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int buttonChecked) {
                RadioButton checked = radioGroup.findViewById(buttonChecked);
                numPreguntas = radioGroup.indexOfChild(checked);
            }
        });

    }

    public void OpenMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("User", user);
        intent.putExtra("Gamemode",mode);
        intent.putExtra("numPregs",numPreguntas);

        startActivity(intent);
        finish();
    }

}