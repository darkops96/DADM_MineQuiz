package com.example.dadm_prac1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "users")
public class UserData implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Username")
    private String username;

    @ColumnInfo(name = "Puntuacion")
    private int points;

    @ColumnInfo(name = "Foto")
    private String userPhoto;

    @ColumnInfo(name = "PartidasJugadas")
    private int timesPlayed;

    @ColumnInfo(name = "UltimaConexion")
    private String lastTime;

    @ColumnInfo(name = "ModoPreguntas")
    private int quizMode;

    @ColumnInfo(name = "NumeroPreguntas")
    private int numPreg;

    public int getQuizMode() {
        return quizMode;
    }

    public void setQuizMode(int quizMode) {
        this.quizMode = quizMode;
    }

    public int getNumPreg() {
        return numPreg;
    }

    public void setNumPreg(int numPreg) {
        this.numPreg = numPreg;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

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
