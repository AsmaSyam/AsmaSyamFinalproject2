package com.example.asmasyamfinalproject.Class;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.asmasyamfinalproject.Class.QuestionData;

@Entity(foreignKeys = {@ForeignKey(entity = QuestionData.class ,
parentColumns = "patternId" , childColumns = "id",
onDelete = ForeignKey.CASCADE , onUpdate = ForeignKey.CASCADE)})
public class Pattern {

    @PrimaryKey
    int patternId ;
    String patternName ;

    int id ;


    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }
}
