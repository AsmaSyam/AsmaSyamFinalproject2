package com.example.asmasyamfinalproject.Class;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity
public class DataOfLevel {

    @PrimaryKey
    int levelNo ;
    int unlockPoints ;

   public int usersId ;


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


