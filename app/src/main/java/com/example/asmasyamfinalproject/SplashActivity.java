package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.asmasyamfinalproject.Class.DataOfLevel;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.Pattern;
import com.example.asmasyamfinalproject.Class.QuestionData;
import com.example.asmasyamfinalproject.databinding.ActivitySplashBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding ;
    GameViewModule module ;

    boolean isFirstInsertInRoom = false ;

    SharedPreferences sp  ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sp = getSharedPreferences("as" , MODE_PRIVATE) ;
        editor = sp.edit() ;

        module = new ViewModelProvider(this).get(GameViewModule.class);

        String fileName = readFromAssets("jsonData.json");

        // Log.d("levelTest", "onCreate: created");

       /* if(isFirstInsertInRoom = sp.getBoolean("isFirstInsertInRoom" , true)){

            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this , HomeActivity.class));
                    finish();
                }
            }, 2000);

        }else {

            parseTheJson(fileName);
            parseTheJsonInsertQuestion(fileName);
            isFirstInsertInRoom = true ;

            editor.putBoolean("isFirstInsertInRoom" , isFirstInsertInRoom);
            editor.commit();



            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this , HomeActivity.class));
                    finish();
                }
            }, 2000);
        }*/

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this , HomeActivity.class));
                finish();
            }
        }, 2000);

        parseTheJson(fileName);
        parseTheJsonInsertQuestion(fileName);



    }

    private void parseTheJson(String string) {
        // هنا رح اعمل البارس
        try {

            JSONArray jsonArray = new JSONArray(string);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                int levelNo = jsonObject.getInt("level_no");
                int unlockPoints = jsonObject.getInt("unlock_points");

                DataOfLevel dataOfLevel = new DataOfLevel();
                dataOfLevel.setLevelNo(levelNo);
                dataOfLevel.setUnlockPoints(unlockPoints);

                Log.d("levelTest", "parseTheJson: "+levelNo +" : "+ i);
                module.insertLevelData(dataOfLevel);

                JSONArray questionsArray = jsonObject.getJSONArray("questions");

                for (int j = 0; j < questionsArray.length(); j++) {
                    JSONObject jsonObject1 = new JSONObject(questionsArray.get(j).toString());
                    int id = jsonObject1.getInt("id");
                    String title = jsonObject1.getString("title");
                    String answer1 = jsonObject1.getString("answer_1");
                    String answer2 = jsonObject1.getString("answer_2");
                    String answer3 = jsonObject1.getString("answer_3");
                    String answer4 = jsonObject1.getString("answer_4");
                    String trueAnswer = jsonObject1.getString("true_answer");
                    int points = jsonObject1.getInt("points");
                    int duration = jsonObject1.getInt("duration");

                    JSONObject patternClass = jsonObject1.getJSONObject("pattern");
                    int patternId = patternClass.getInt("pattern_id");
                    String patternName = patternClass.getString("pattern_name");

                    Pattern pattern = new Pattern();
                    pattern.setPatternId(patternId);
                    pattern.setPatternName(patternName);

                    module.insertPatternData(pattern);

//                    String hint = jsonObject1.getString("hint");



//                    QuestionData questionData = new QuestionData();
//                    questionData.setId(id);
//                    questionData.setTitle(title);
//                    questionData.setAnswer1(answer1);
//                    questionData.setAnswer2(answer2);
//                    questionData.setAnswer3(answer3);
//                    questionData.setAnswer4(answer4);
//                    questionData.setTrueAnswer(trueAnswer);
//                    questionData.setPoints(points);
//                    questionData.setDuration(duration);
//                    questionData.setPatternId(patternId);
//                    questionData.setHint(hint);

//                    module.insertQuestionData(questionData);


                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseTheJsonInsertQuestion(String string) {
        // هنا رح اعمل البارس
        try {

            JSONArray jsonArray = new JSONArray(string);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                int levelNo = jsonObject.getInt("level_no");
                int unlockPoints = jsonObject.getInt("unlock_points");

                DataOfLevel dataOfLevel = new DataOfLevel();
                dataOfLevel.setLevelNo(levelNo);
                dataOfLevel.setUnlockPoints(unlockPoints);

             //   module.insertLevelData(dataOfLevel);

                JSONArray questionsArray = jsonObject.getJSONArray("questions");

                for (int j = 0; j < questionsArray.length(); j++) {
                    JSONObject jsonObject1 = new JSONObject(questionsArray.get(j).toString());
                    int id = jsonObject1.getInt("id");
                    String title = jsonObject1.getString("title");
                    String answer1 = jsonObject1.getString("answer_1");
                    String answer2 = jsonObject1.getString("answer_2");
                    String answer3 = jsonObject1.getString("answer_3");
                    String answer4 = jsonObject1.getString("answer_4");
                    String trueAnswer = jsonObject1.getString("true_answer");
                    int points = jsonObject1.getInt("points");
                    int duration = jsonObject1.getInt("duration");

                    JSONObject patternClass = jsonObject1.getJSONObject("pattern");
                    int patternId = patternClass.getInt("pattern_id");
                    String patternName = patternClass.getString("pattern_name");

                    Pattern pattern = new Pattern();
                    pattern.setPatternId(patternId);
                    pattern.setPatternName(patternName);

                 //   module.insertPatternData(pattern);

                    String hint = jsonObject1.getString("hint");



                    QuestionData questionData = new QuestionData(title,answer1,answer2,answer3,answer4,
                            trueAnswer,points,duration,patternId,hint,levelNo);
//                    questionData.setId(id);
//                    questionData.setTitle(title);
//                    questionData.setAnswer1(answer1);
//                    questionData.setAnswer2(answer2);
//                    questionData.setAnswer3(answer3);
//                    questionData.setAnswer4(answer4);
//                    questionData.setTrueAnswer(trueAnswer);
//                    questionData.setPoints(points);
//                    questionData.setDuration(duration);
//                    questionData.setPatternId(patternId);
//                    questionData.setHint(hint);

                   module.insertQuestionData(questionData);


                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    private String readFromAssets(String fileName) {
        String string = "";
        try {
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] byteObject = new byte[size];
            inputStream.read(byteObject);
            inputStream.close();
            string = new String(byteObject , "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return string ;

    }


}