package com.example.asmasyamfinalproject.Class;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.asmasyamfinalproject.Dao.LevelDao;
import com.example.asmasyamfinalproject.Dao.QuestionDao;
import com.example.asmasyamfinalproject.Dao.UsersDao;

import java.util.List;

public class Repository {

    private LevelDao levelDao;
    private QuestionDao questionDao;
    private UsersDao usersDao;

    Repository(Application application) {
        GameDatabase db = GameDatabase.getDatabase(application);
        levelDao = db.levelDao();
        questionDao = db.questionDao();
        usersDao = db.usersDao();
    }

    LiveData<List<DataOfLevel>> getAllLevel(){

        return levelDao.getAllLevel() ;
    }

    LiveData<List<QuestionData>> getAllQuestions(){

        return questionDao.getAllQuestions();
    }


    LiveData<List<DataOfUsers>> getALlUsers(){

        return usersDao.getALlUsers();
    }

}
