package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.asmasyamfinalproject.Class.GameViewModule;

public class ProfileActivity extends AppCompatActivity {

    GameViewModule module ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       // module.insertUsersData();
    }
}