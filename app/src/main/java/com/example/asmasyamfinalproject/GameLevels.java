package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.asmasyamfinalproject.Class.DataOfLevel;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.QuestionAdapter;
import com.example.asmasyamfinalproject.Class.QuestionData;
import com.example.asmasyamfinalproject.Fragments.ChooseFragment;
import com.example.asmasyamfinalproject.Fragments.Complete_Question_Fragment;
import com.example.asmasyamfinalproject.Fragments.TrueOrFalseQuestion;
import com.example.asmasyamfinalproject.databinding.ActivityGamelevelsBinding;

import java.util.ArrayList;
import java.util.List;

public class GameLevels extends AppCompatActivity {

    ActivityGamelevelsBinding binding ;
    GameViewModule module ;

    //ArrayList<QuestionData> arrayList ;

    String title ;
    String answer1 ;
    String answer2 ;
    String answer3 ;
    String answer4 ;
    int patternId ;
    int puzzleNo ;
    String trueAnswer ;

    int levelNo ;

    ArrayList<Fragment> fragmentArrayList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamelevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentArrayList  = new ArrayList<>();

        Intent intent = getIntent();
        levelNo = intent.getIntExtra("levelNo" ,0 );


        module = new ViewModelProvider(this).get(GameViewModule.class);


                module.getAllQuestionsByLevelId(levelNo).observe(GameLevels.this, new Observer<List<QuestionData>>() {
                    @Override
                    public void onChanged(List<QuestionData> questionData) {
//                        arrayList = (ArrayList<QuestionData>) questionData;

                        Log.d("levelNo", "onChanged: " + levelNo);
                        Log.d("sizeArray", "onChanged: " + questionData.size());

                        for (int i = 0; i < questionData.size(); i++) {
                            Log.d("questionsTest", "onChanged: "+questionData.get(i).getId()+" : "+
                                    questionData.get(i).getTitle()+" : "+questionData.get(i).getLevelNo());

                            title = questionData.get(i).getTitle();
                            answer1 = questionData.get(i).getAnswer1();
                            answer2 = questionData.get(i).getAnswer2();
                            answer3 = questionData.get(i).getAnswer3();
                            answer4 = questionData.get(i).getAnswer4();
                            patternId = questionData.get(i).getPatternId();
                            puzzleNo = questionData.size();
                            trueAnswer = questionData.get(i).getTrueAnswer();

                            Log.d("title", "onChanged: " + title);
                            Log.d("answer1", "onChanged: " + answer1);
                            Log.d("answer2", "onChanged: " + answer2);
                            Log.d("answer3", "onChanged: " + answer3);
                            Log.d("patternId", "onChanged: " + patternId);


                            if(patternId == 2){
                                fragmentArrayList.add(ChooseFragment.newInstance(title , answer1 , answer2
                                        , answer3 , answer4 , patternId , levelNo , puzzleNo , trueAnswer));
                                Log.d("title", "onCreate: " +title);
                            }
                            else if(patternId == 3){
                                fragmentArrayList.add(Complete_Question_Fragment.newInstance(title , patternId , levelNo , puzzleNo , trueAnswer));
                            }

                            else if(patternId == 1){
                                fragmentArrayList.add(TrueOrFalseQuestion.newInstance(title , patternId  , levelNo , puzzleNo , trueAnswer));
                            }

                            QuestionAdapter adapter = new QuestionAdapter(GameLevels.this , fragmentArrayList);

                            binding.viewPager.setAdapter(adapter);

                            //  Log.d("title", "onChanged: " + title);
                            // Log.d("answer1", "onChanged: " + answer1);
                            // Log.d("answer2", "onChanged: " + answer2);
                            //Log.d("answer3", "onChanged: " + answer3);
                            //Log.d("patternId", "onChanged: " + patternId);
                        }
                    }

                    //  Toast.makeText(this, title, Toast.LENGTH_SHORT).show();


                });

           //     ChooseFragment fragment = new ChooseFragment();


            }



    }
