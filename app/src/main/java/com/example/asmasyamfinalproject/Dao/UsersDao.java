package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.asmasyamfinalproject.Class.DataOfUsers;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("select * from DataOfUsers")
    LiveData<List<DataOfUsers>> getALlUsers();

}
