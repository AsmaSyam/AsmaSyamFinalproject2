package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.asmasyamfinalproject.Class.DataOfLevel;
import com.example.asmasyamfinalproject.Class.QuestionData;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuestionData(QuestionData questionData);

    @Query("select * from QuestionData")
    LiveData<List<QuestionData>> getAllQuestions();

    @Query("select * from QuestionData where levelNo = :levelNo")
    LiveData<List<QuestionData>> getAllQuestionsByLevelId(int levelNo);

}
