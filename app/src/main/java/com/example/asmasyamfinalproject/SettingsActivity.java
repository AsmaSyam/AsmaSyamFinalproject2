package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.MyJobService;
import com.example.asmasyamfinalproject.databinding.ActivitySettingsBinding;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding ;
    boolean isVoiceActivation = true ;
    boolean isNotificationActivation  = true;
    MediaPlayer mediaPlayer ;
    GameViewModule module ;

    int UsersId ;
    String UserName ;
    String Email ;
    String DateOfBirth ;
    String Gender ;
    String Countries ;

    int Score ;
    int CountGame ;
    int RightGameCount ;
    int WrongGameCount ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        module = new ViewModelProvider(this).get(GameViewModule.class);

        ComponentName componentName = new ComponentName(getBaseContext(), MyJobService.class);
        JobInfo info = null ;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            info = new JobInfo.Builder(100 , componentName)
                    .setPeriodic(24*60*60*1000 , 5*60*1000)
                    .build();
        }

        //24*60*60*1000
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(info);


        mediaPlayer = MediaPlayer.create(this, R.raw.sound);

        binding.buttonVoiceActivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isVoiceActivation){
                    mediaPlayer.pause();
                    binding.buttonVoiceActivation.setText("The sound is not activated");
                    isVoiceActivation = false ;
                }else {
                    mediaPlayer.start();
                    binding.buttonVoiceActivation.setText("Voice Activation");
                    isVoiceActivation = true ;
                }
            }
        });


        binding.buttonNotificationActivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNotificationActivation){
                    // هنا رح اكتب كود ايقاف تفعيل الاشعارات
                    binding.buttonNotificationActivation.setText("The notification is not activated");
                    isNotificationActivation = false ;
                }else {
                    // هنا رح اكتب كود اعادة تفعيل الاشعارات
                    binding.buttonNotificationActivation.setText("Notification Activation");
                    isNotificationActivation = true ;
                }
            }
        });

        module.getALlUsers().observe(this, new Observer<List<DataOfUsers>>() {
            @Override
            public void onChanged(List<DataOfUsers> dataOfUsers) {

                for (int i = 0; i < dataOfUsers.size(); i++) {

                     UsersId = dataOfUsers.get(i).getUsersId();
                     UserName = dataOfUsers.get(i).getUserName();
                     Email = dataOfUsers.get(i).getEmail();
                     DateOfBirth = dataOfUsers.get(i).getDateOfBirth();
                     Gender = dataOfUsers.get(i).getGender();
                     Countries = dataOfUsers.get(i).getCountry();


                     Score = dataOfUsers.get(i).getScore();
                     CountGame = dataOfUsers.get(i).getCountGame();
                     RightGameCount = dataOfUsers.get(i).getRightGameCount();
                     WrongGameCount = dataOfUsers.get(i).getWrongGameCount();
                }


            }
        });

        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                module.deleteUsersData(new DataOfUsers(UsersId , UserName , Email , DateOfBirth , Gender , Countries ,
                        Score , CountGame , RightGameCount , WrongGameCount));
            }
        });
    }
}