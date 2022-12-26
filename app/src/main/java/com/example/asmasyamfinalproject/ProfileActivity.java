package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.databinding.ActivityProfileBinding;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding ;

    GameViewModule module ;
    int age ;
    String Age ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // module.insertUsersData();

       /* binding.dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCalendar = Calendar.getInstance();
                int year = mCalendar.get(Calendar.YEAR);
                int month = mCalendar.get(Calendar.MONTH);
                int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
                binding.dateOfBirth.setText(dayOfMonth + "/" + (month+1) + "/" + year);
            }
        });*/
    }
}