package com.example.dadm_prac1;

import static androidx.room.OnConflictStrategy.*;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface UserDao {
    //Insert query
    @Insert(onConflict = IGNORE)
    void insert(UserData mainData);

    //Delete query
    @Delete
    void delete(UserData mainData);

    //Delete all query
    @Delete
    void reset(List<UserData> mainData);

    //Update points query
    @Query("UPDATE users SET puntuacion = :sPoints WHERE username = :sUsername")
    void updatePoints(String sUsername, int sPoints);

    //Update date query
    @Query("UPDATE users SET UltimaConexion = :sDate WHERE username = :sUsername")
    void updateDate(String sUsername, String sDate);

    //Update photo query
    @Query("UPDATE users SET Foto = :sPhoto WHERE username = :sUsername")
    void updatePhoto(String sUsername, String sPhoto);

    //Update games query
    @Query("UPDATE users SET PartidasJugadas = :sGames WHERE username = :sUsername")
    void updateGames(String sUsername, int sGames);

    //Get all data query
    @Query("SELECT * FROM users")
    List<UserData> getAll();
}
