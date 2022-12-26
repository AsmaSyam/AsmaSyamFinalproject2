package com.example.asmasyamfinalproject.Class;


import android.app.Application;

import androidx.lifecycle.LiveData;


import com.example.asmasyamfinalproject.Dao.LevelDao;
import com.example.asmasyamfinalproject.Dao.PatternDao;
import com.example.asmasyamfinalproject.Dao.QuestionDao;
import com.example.asmasyamfinalproject.Dao.UsersDao;

import java.util.List;

public class Repository {

    private LevelDao levelDao;
    private QuestionDao questionDao;
    private UsersDao usersDao;
    private PatternDao patternDao;

    Repository(Application application) {
        GameDatabase db = GameDatabase.getDatabase(application);
        levelDao = db.levelDao();
        questionDao = db.questionDao();
        usersDao = db.usersDao();
        patternDao = db.patternDao();
    }

    LiveData<List<DataOfLevel>> getAllLevel(){

        return levelDao.getAllLevel() ;
    }

    void insertLevelData(DataOfLevel dataOfLevel){

        GameDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDao.insertLevelData(dataOfLevel);
            }
        });
    }

    LiveData<List<QuestionData>> getAllQuestions(){

        return questionDao.getAllQuestions();
    }

    void insertQuestionData(QuestionData questionData){

        GameDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                questionDao.insertQuestionData(questionData);
            }
        });
    }



    LiveData<List<DataOfUsers>> getALlUsers(){

        return usersDao.getALlUsers();
    }

    void insertUsersData(DataOfUsers dataOfUsers){

        GameDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                usersDao.insertUsersData(dataOfUsers);
            }
        });
    }


    void insertPatternData(Pattern pattern){

        GameDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternDao.insertPatternData(pattern);
            }
        });
    }


    LiveData<List<Pattern>> getALlPattern(){

        return patternDao.getALlPattern();
    }


}
