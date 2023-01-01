package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.QuestionData;
import com.example.asmasyamfinalproject.databinding.ActivityHomeBinding;

import java.util.Calendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding ;
    MediaPlayer mediaPlayer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        GameViewModule vm = new ViewModelProvider(this).get(GameViewModule.class);

        Calendar now = Calendar.getInstance();
        int Year = now.get(Calendar.YEAR);
        int Month = now.get(Calendar.MONTH);
        int DayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        String Date = (DayOfMonth+"/"+Month+"/"+Year);

        vm.insertUsersData(new DataOfUsers(1 , "User1" , "User1@gmail.com" ,
                 "23/2/2003" , "Male" , "Palestine" , 0 ,0 ,0 ,0));



        vm.getAllQuestions().observe(this, new Observer<List<QuestionData>>() {
            @Override
            public void onChanged(List<QuestionData> questionData) {
                for (QuestionData q : questionData) {
                    Log.d("questionsTest", "onChanged: "+q.getId()+" : "+q.getTitle()+" : "+q.getLevelNo());

                }
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.sound );
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        binding.buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getBaseContext() , StartPlayActivity.class));
            }
        });

        binding.buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , SettingsActivity.class));
            }
        });

        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    }

   /* @Override
    protected void onPause() {
        super.onPause();

        mediaPlayer.stop();
        mediaPlayer.release();
    }*/
}