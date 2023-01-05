package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.asmasyamfinalproject.Class.DataOfUsers;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Fragments.ChooseFragment;
import com.example.asmasyamfinalproject.Fragments.Complete_Question_Fragment;
import com.example.asmasyamfinalproject.Fragments.TrueOrFalseQuestion;
import com.example.asmasyamfinalproject.databinding.ActivityProfileBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

public class ProfileActivity extends AppCompatActivity  {

    ActivityProfileBinding binding;

    GameViewModule module;

    SharedPreferences sp  ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        module = new ViewModelProvider(this).get(GameViewModule.class);

        sp = getSharedPreferences("as" , MODE_PRIVATE) ;
        editor = sp.edit() ;




       // للتاكد من حجم الأري والبيانات يلي بداخلها
        module.getALlUsers().observe(this, new Observer<List<DataOfUsers>>() {
            @Override
            public void onChanged(List<DataOfUsers> dataOfUsers) {
                for (int i = 0; i < dataOfUsers.size(); i++) {
                    Log.d("dataOfUsersSize", "onChanged: " + dataOfUsers.size());
                    Log.d("UsersId", "onChanged: " + dataOfUsers.get(i).getUsersId());
                    Log.d("UserName", "onChanged: " + dataOfUsers.get(i).getUserName());
                    Log.d("Gender", "onChanged: " + dataOfUsers.get(i).getGender());
                    Log.d("Email", "onChanged: " + dataOfUsers.get(i).getEmail());
                    Log.d("DateOfBirth", "onChanged: " + dataOfUsers.get(i).getDateOfBirth());
                }

            }
        });


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

                    int score = sp.getInt("Score" , 0);
                    int gameCount = sp.getInt("gameCount" , 0);
                    int rightGameCount = sp.getInt("rightGameCount" , 0);
                    int wrongGameCount = sp.getInt("wrongGameCount" , 0);

//                    new Handler().postDelayed(new Runnable() {
  //                      @Override
    //                    public void run() {
                            module.updateUsersData(new DataOfUsers(UsersId , UserName , Email , DateOfBirth , Gender ,
                                    Countries , score  ,gameCount , rightGameCount , wrongGameCount));
      //                }
       //             }, 20000);


                    binding.userName.setText(UserName);
                    binding.email.setText(Email);
                    binding.dateOfBirth.setText(DateOfBirth);

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
                        && (binding.radioMale.isChecked() || binding.radioFemale.isChecked())
                        && binding.countriesSpinner.getSelectedItem() != null
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
                    // هنا رح احدث على الروم داتابيز
                }
                else {
                    Toast.makeText(ProfileActivity.this, "Insert all of the data", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }


}