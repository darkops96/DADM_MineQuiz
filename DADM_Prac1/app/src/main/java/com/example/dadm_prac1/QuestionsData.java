package com.example.dadm_prac1;

import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "questions_table")
public class QuestionsData implements Serializable {
    //Generamos un ID
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //Guarda la pregunta
    @ColumnInfo(name = "question")
    private String question;

    //Guarda la respuesta 1
    @ColumnInfo(name = "Answer 1")
    private String answer1;

    //Guarda la respuesta 2
    @ColumnInfo(name = "Answer 2")
    private String answer2;

    //Guarda la respuesta 3
    @ColumnInfo(name = "Answer 3")
    private String answer3;

    //Guarda la respuesta 4
    @ColumnInfo(name = "Answer 4")
    private String answer4;

    //Guarda las respuestas correctas
    @ColumnInfo(name = "Correct Answers")
    private int correctAnswers;

    //Guarda el audio a reproducir
    @ColumnInfo(name = "Audio Selection")
    private int audio;

    //Guarda el tipo de pregunta
    @ColumnInfo(name = "Question type")
    private int type;

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
