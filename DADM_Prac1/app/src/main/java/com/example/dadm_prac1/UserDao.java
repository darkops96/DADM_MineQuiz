package com.example.dadm_prac1;

import static androidx.room.OnConflictStrategy.*;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

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

    //Update query
    @Query("UPDATE users SET puntuacion = :sPoints WHERE username = :sUsername")
    void update(String sUsername, int sPoints);

    //Get all data query
    @Query("SELECT * FROM users")
    List<UserData> getAll();
}
