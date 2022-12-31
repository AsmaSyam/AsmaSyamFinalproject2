package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.databinding.ActivityProfileBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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


        module.getALlUsers().observe(this, new Observer<List<DataOfUsers>>() {
            @SuppressLint("ResourceType")
            @Override
            public void onChanged(List<DataOfUsers> dataOfUsers) {

                for (int i = 0; i < dataOfUsers.size(); i++) {

                   String UserName = dataOfUsers.get(i).getUserName();
                   String Email = dataOfUsers.get(i).getEmail();
                   Date DateOfBirth = dataOfUsers.get(i).getDateOfBirth();
                   String Gender = dataOfUsers.get(i).getGender();
                   String Countries = dataOfUsers.get(i).getCountry();

                   int Score = dataOfUsers.get(i).getScore();
                   int CountGame = dataOfUsers.get(i).getCountGame();
                   int RightGameCount = dataOfUsers.get(i).getRightGameCount();
                   int WrongGameCount = dataOfUsers.get(i).getWrongGameCount();

                    binding.userName.setText(UserName);
                    binding.email.setText(Email);
                    binding.dateOfBirth.setText((CharSequence) DateOfBirth);

                   // int gender = binding.radioGroup.getCheckedRadioButtonId();
                  //  RadioButton radioButton =findViewById(gender);

                    // radioButton.setText(gender);

                    binding.score.setText(Score);
                    binding.gameCount.setText(CountGame);
                    binding.rightGameCount.setText(RightGameCount);
                    binding.wrongGameCount.setText(WrongGameCount);
                }

            }
        });

        binding.dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //هنا مستخدم الكالندر ليظهرلي الوقت الافتراضي يلي رح يظهر اول ما يفتح الديالوج

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

                                binding.dateOfBirth.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

                              /*  int year1 = Calendar.YEAR;
                                if (year <= year1){
                                    binding.dateOfBirth.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

                                }else if (year > year1){
                                    Toast.makeText(ProfileActivity.this, "Can not choose it", Toast.LENGTH_SHORT).show();
                                }*/


                               // int day = Calendar.DAY_OF_MONTH;
                                // int month = Calendar.MONTH;


                            }
                        },
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection

                );
                dpd.show(getSupportFragmentManager(), "Datepickerdialog");

            }
        });

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.userName != null && binding.dateOfBirth != null && binding.email != null && binding.radioGroup != null
                && binding.countriesSpinner != null && binding.score != null && binding.gameCount != null
                        && binding.rightGameCount != null && binding.wrongGameCount != null){

                    String UserName = binding.userName.getText().toString();
                    String Email = binding.email.getText().toString();
                    Date DateOfBirth = (Date) binding.dateOfBirth.getText();


                    int gender = binding.radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton =findViewById(gender);


                    String TextGender = radioButton.getText().toString();
                    String Countries = binding.countriesSpinner.getSelectedItem().toString();

                    int Score = Integer.parseInt(binding.score.getText().toString());
                    int GameCount = Integer.parseInt(binding.gameCount.getText().toString());
                    int RightGameCount = Integer.parseInt(binding.rightGameCount.getText().toString());
                    int WrongGameCount = Integer.parseInt(binding.wrongGameCount.getText().toString());

                    module.insertUsersData(new DataOfUsers(1 ,UserName , Email , DateOfBirth ,TextGender , Countries , Score ,
                            GameCount , RightGameCount , WrongGameCount));
                    // هنا رح اخزن في الروم داتابيز
                }





            }
        });
    }
}