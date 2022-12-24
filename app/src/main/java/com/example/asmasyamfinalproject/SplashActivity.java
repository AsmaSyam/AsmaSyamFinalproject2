package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {

                    Intent intent = new Intent(getBaseContext() , HomeActivity.class);
                }
            }
        });

        thread.start();

        module = new ViewModelProvider(this).get(GameViewModule.class);



        String fileName = readFromAssets("jsonData.json");

        parseTheJson(fileName);



    }

    private void parseTheJson(String string) {
        // هنا رح اعمل البارس
        try {

            JSONArray jsonArray = new JSONArray(string);

            ArrayList<DataOfLevel> dataOfLevelArrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                int levelNo = jsonObject.getInt("level_no");
                int unlockPoints = jsonObject.getInt("unlock_points");

                DataOfLevel dataOfLevel = new DataOfLevel();
                dataOfLevel.setLevelNo(levelNo);
                dataOfLevel.setUnlockPoints(unlockPoints);

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

                    String hint = jsonObject1.getString("hint");



                    QuestionData questionData = new QuestionData();
                    questionData.setId(id);
                    questionData.setTitle(title);
                    questionData.setAnswer1(answer1);
                    questionData.setAnswer2(answer2);
                    questionData.setAnswer3(answer3);
                    questionData.setAnswer4(answer4);
                    questionData.setTrueAnswer(trueAnswer);
                    questionData.setPoints(points);
                    questionData.setDuration(duration);
                    questionData.setPatternId(patternId);
                    questionData.setHint(hint);


                }

                dataOfLevelArrayList.add(dataOfLevel);
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