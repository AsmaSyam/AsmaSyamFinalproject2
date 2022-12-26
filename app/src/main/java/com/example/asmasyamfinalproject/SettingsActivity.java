package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.asmasyamfinalproject.databinding.ActivitySettingsBinding;
import com.example.asmasyamfinalproject.databinding.ActivitySplashBinding;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding ;
    boolean isVoiceActivation = true ;
    boolean isNotificationActivation  = true;
    MediaPlayer mediaPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                    binding.buttonVoiceActivation.setText("The notification is not activated");
                    isNotificationActivation = false ;
                }else {
                    // هنا رح اكتب كود اعادة تفعيل الاشعارات
                    binding.buttonVoiceActivation.setText("Notification Activation");
                    isNotificationActivation = true ;
                }
            }
        });
    }
}