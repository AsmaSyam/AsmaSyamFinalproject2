package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.Pattern;

import java.util.List;

@Dao
public interface PatternDao {

    @Insert
    void insertPatternData(Pattern pattern);


    @Query("select * from pattern")
    LiveData<List<Pattern>> getALlPattern();

}
