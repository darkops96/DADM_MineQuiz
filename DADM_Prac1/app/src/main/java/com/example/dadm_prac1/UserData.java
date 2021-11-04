package com.example.dadm_prac1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class UserData implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Username")
    private String username;

    @ColumnInfo(name = "Puntuacion")
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
