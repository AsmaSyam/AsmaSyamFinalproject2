package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.asmasyamfinalproject.Class.DataOfLevel;

import java.util.List;

@Dao
public interface LevelDao {

    @Query("select * from DataOfLevel")
    LiveData<List<DataOfLevel>> getAllLevel();

}
