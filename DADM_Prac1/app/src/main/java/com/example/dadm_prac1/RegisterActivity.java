package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Button btAdd, btAnon;
    RecyclerView recyclerView;

    List<UserData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomUsersDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_register);

        btAdd = findViewById(R.id.bt_add);
        btAnon = findViewById(R.id.bt_anon);
        recyclerView = findViewById(R.id.recycler_view);

        //Inicializamos la base de datos
        database = RoomUsersDB.getInstance(this);

        //Guardamos los valores de la base de datos en el data list
        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MainAdapter(RegisterActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenNewUser();
            }
        });

        btAnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMenu();
            }
        });
    }

    public void OpenMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("User", "Steve");
        intent.putExtra("Gamemode", 0);
        intent.putExtra("numPregs", 0);
        startActivity(intent);
    }

    public void OpenNewUser(){
        Intent intent = new Intent(this, Activity_NewUser.class);
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