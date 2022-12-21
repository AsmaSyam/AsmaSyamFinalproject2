package com.example.asmasyamfinalproject.Class;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity
@TypeConverters({DataConverter.class})
public class DataOfUsers {

    @PrimaryKey(autoGenerate = true)
    int usersId ;

    String userName ;
    String email ;
    Date dateOfBirth ;
    String gender ;
    String country ;

    public DataOfUsers(String userName, String email, Date dateOfBirth, String gender, String country) {
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
