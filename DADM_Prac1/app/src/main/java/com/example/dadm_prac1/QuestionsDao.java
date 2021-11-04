package com.example.dadm_prac1;

import static androidx.room.OnConflictStrategy.*;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionsDao {
    //Insert query
    @Insert(onConflict = REPLACE)
    void insert(QuestionsData mainData);

    //Delete query
    @Delete
    void delete(QuestionsData mainData);

    //Delete all query
    @Delete
    void reset(List<QuestionsData> mainData);

    //Update query
    @Query("UPDATE questions_table SET question = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    //Get all data query
    @Query("SELECT * FROM questions_table")
    List<QuestionsData> getAll();
}
