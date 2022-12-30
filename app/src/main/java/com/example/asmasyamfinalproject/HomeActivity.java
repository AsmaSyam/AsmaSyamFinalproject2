package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.QuestionData;
import com.example.asmasyamfinalproject.databinding.ActivityHomeBinding;

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
        vm.getAllQuestions().observe(this, new Observer<List<QuestionData>>() {
            @Override
            public void onChanged(List<QuestionData> questionData) {
                for (QuestionData q :
                        questionData) {
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