package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.databinding.ActivityProfileBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;

    GameViewModule module;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        module = new ViewModelProvider(this).get(GameViewModule.class);

         module.getALlUsers().observe(this, new Observer<List<DataOfUsers>>() {
            @Override
            public void onChanged(List<DataOfUsers> dataOfUsers) {

                for (int i = 0; i < dataOfUsers.size(); i++) {

                   int UsersId = dataOfUsers.get(i).getUsersId();
                   String UserName = dataOfUsers.get(i).getUserName();
                   String Email = dataOfUsers.get(i).getEmail();
                   String DateOfBirth = dataOfUsers.get(i).getDateOfBirth();
                   String Gender = dataOfUsers.get(i).getGender();
                   String Countries = dataOfUsers.get(i).getCountry();

                   int Score = dataOfUsers.get(i).getScore();
                   int CountGame = dataOfUsers.get(i).getCountGame();
                   int RightGameCount = dataOfUsers.get(i).getRightGameCount();
                   int WrongGameCount = dataOfUsers.get(i).getWrongGameCount();

                    binding.userName.setText(UserName);
                    binding.email.setText(Email);
                    binding.dateOfBirth.setText((CharSequence) DateOfBirth);



                    // radioButton.setText(gender);

                    binding.score.setText(String.valueOf(Score));
                    binding.gameCount.setText(String.valueOf(CountGame));
                    binding.rightGameCount.setText(String.valueOf(RightGameCount));
                    binding.wrongGameCount.setText(String.valueOf(WrongGameCount));

                   /* int gender = binding.radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton =findViewById(gender);
                    String radioText = radioButton.getText().toString();

                      switch (gender){
                        case  R.id.radioMale:
                            break;
                        case R.id.radioFemale:
                    }*/

                    if (Gender.equalsIgnoreCase("Male")){
                        binding.radioMale.setChecked(true);
                    }else if (Gender.equalsIgnoreCase("Female")){
                        binding.radioFemale.setChecked(true);
                    }

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

                                binding.dateOfBirth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

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

        //بدي احط هنا بدل  Update <- insert  لانو عمل انسيرت في Home

       binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.userName.getText() != null && binding.dateOfBirth.getText() != null && binding.email.getText() != null
                        && binding.radioGroup != null && binding.countriesSpinner.getSelectedItem() != null
                        && binding.score.getText() != null && binding.gameCount.getText() != null
                        && binding.rightGameCount.getText() != null && binding.wrongGameCount.getText() != null){

                    String UserName = binding.userName.getText().toString();
                    String Email = binding.email.getText().toString();
                    String DateOfBirth = binding.dateOfBirth.getText().toString();


                    int gender = binding.radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton =findViewById(gender);



                    String TextGender = radioButton.getText().toString();
                    String Countries = binding.countriesSpinner.getSelectedItem().toString();

                    int Score = Integer.parseInt(binding.score.getText().toString());
                    int GameCount = Integer.parseInt(binding.gameCount.getText().toString());
                    int RightGameCount = Integer.parseInt(binding.rightGameCount.getText().toString());
                    int WrongGameCount = Integer.parseInt(binding.wrongGameCount.getText().toString());

                    module.updateUsersData(new DataOfUsers(1 ,UserName , Email , DateOfBirth ,TextGender , Countries , Score ,
                            GameCount , RightGameCount , WrongGameCount));
                    // هنا رح اخزن في الروم داتابيز
                }
                else {
                    Toast.makeText(ProfileActivity.this, "Insert all of the data", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }
}