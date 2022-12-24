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


    public DataOfLevel(int levelNo, int unlockPoints) {
        this.levelNo = levelNo;
        this.unlockPoints = unlockPoints;
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
}


