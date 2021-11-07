package com.example.dadm_prac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Activity_Ranking extends AppCompatActivity {

    Button back;
    ArrayList<String> listDatos;
    RecyclerView recycler;
    String user;
    List<UserData> usersList = new ArrayList<>();
    RoomUsersDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_ranking);

        Intent intent = getIntent();
        user = intent.getStringExtra("User").toString().trim();

        database = RoomUsersDB.getInstance(this);
        usersList = database.mainDao().getAll();

        back = (Button) findViewById(R.id.B_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { OpenMenu(); }
        });
        recycler=(RecyclerView) findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recycler.setLayoutManager(new GridLayoutManager(this,2));

        listDatos=new ArrayList<String>();
        List<UserData> orderUsersList = new ArrayList<>();
        orderUsersList.add(usersList.get(0));
        int totalUsers = usersList.size();
        usersList.remove(0);
        int aux = 0;
        while (orderUsersList.size() < totalUsers) {
            if (usersList.get(aux).getPoints() > orderUsersList.get(0).getPoints()) {
                orderUsersList.add(0, usersList.get(aux));
                usersList.remove(aux);
            } else if (usersList.get(aux).getPoints() == orderUsersList.get(0).getPoints()) {
                orderUsersList.add(1, usersList.get(aux));
                usersList.remove(aux);
            } else if (usersList.size() == 1){
                orderUsersList.add(usersList.get(aux));
                usersList.remove(aux);
            }
            if(aux < usersList.size()-1){
                aux++;
            } else {
                aux = 0;
            }
        }

        int rankPos = 1;
        for (UserData userD: orderUsersList) {
            listDatos.add(rankPos+". "+userD.getUsername()+": "+ userD.getPoints()+" puntos");
            rankPos++;
        }

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);
    }
    public void OpenMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("User", user);
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