package com.example.asmasyamfinalproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.QuestionData;

import java.util.Date;
import java.util.List;

@Dao
public interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUsersData(DataOfUsers dataOfUsers);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateUsersData(DataOfUsers dataOfUsers);

    @Query("select * from DataOfUsers")
    LiveData<List<DataOfUsers>> getALlUsers();

}
