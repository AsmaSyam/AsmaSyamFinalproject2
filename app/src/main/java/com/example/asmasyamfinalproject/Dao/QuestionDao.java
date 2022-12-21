package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.asmasyamfinalproject.Class.QuestionData;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("select * from QuestionData")
    LiveData<List<QuestionData>> getAllQuestions();

}
