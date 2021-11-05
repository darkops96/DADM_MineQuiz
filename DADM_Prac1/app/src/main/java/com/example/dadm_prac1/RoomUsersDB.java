package com.example.dadm_prac1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserData.class}, version = 1, exportSchema = false)
public abstract class RoomUsersDB extends RoomDatabase {
    //Create database instance
    private static RoomUsersDB database;
    //Define database name
    private static String DATABASE_NAME = "Users";

    public synchronized static RoomUsersDB getInstance(final Context context){
        //Miramos si ya existe
        if(database == null){
            //Inicializamos la base de datos
            database = Room.databaseBuilder(context.getApplicationContext(), RoomUsersDB.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return database;
    }

    //Create Dao
    public abstract UserDao mainDao();
}
