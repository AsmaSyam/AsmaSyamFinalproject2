package com.example.asmasyamfinalproject.Class;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GameViewModule extends AndroidViewModel {


    private Repository repository ;

    public GameViewModule(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }



    LiveData<List<DataOfLevel>> getAllLevel(){

         return repository.getAllLevel();
    }

    void insertLevelData(DataOfLevel dataOfLevel){

        repository.insertLevelData(dataOfLevel);
    }


    LiveData<List<QuestionData>> getAllQuestions(){

        return repository.getAllQuestions();
    }


    void insertQuestionData(QuestionData questionData){

        repository.insertQuestionData(questionData);

    }



    LiveData<List<DataOfUsers>> getALlUsers(){

        return repository.getALlUsers();
    }

    void insertUsersData(DataOfUsers dataOfUsers){

        repository.insertUsersData(dataOfUsers);

    }


    void insertPatternData(Pattern pattern){

        repository.insertPatternData(pattern);
    }


    LiveData<List<Pattern>> getALlPattern(){

        return repository.getALlPattern();
    }

}
