package com.example.asmasyamfinalproject.Class;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(foreignKeys = {@ForeignKey(entity = DataOfUsers.class ,
parentColumns = "levelNo" , childColumns = "usersId" ,
onDelete = ForeignKey.CASCADE , onUpdate = ForeignKey.CASCADE)})
public class DataOfLevel {

    @PrimaryKey
    int levelNo ;
    int unlockPoints ;

    int usersId ;

    ArrayList<QuestionData> questions ;


    public DataOfLevel(int levelNo, int unlockPoints, ArrayList<QuestionData> questions) {
        this.levelNo = levelNo;
        this.unlockPoints = unlockPoints;
        this.questions = questions;
    }

    public DataOfLevel() {

    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getUnlockPoints() {
        return unlockPoints;
    }

    public void setUnlockPoints(int unlockPoints) {
        this.unlockPoints = unlockPoints;
    }

    public ArrayList<QuestionData> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionData> questions) {
        this.questions = questions;
    }
}


