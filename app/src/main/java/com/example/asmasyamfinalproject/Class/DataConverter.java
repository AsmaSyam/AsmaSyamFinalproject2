package com.example.asmasyamfinalproject.Class;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConverter {

    @TypeConverter
    public long getLong(Date date){
        return date.getTime();
    }

    @TypeConverter
    public Date getDate(Long date){
        return new Date(date);
    }
}
