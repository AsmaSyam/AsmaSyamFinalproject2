package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

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

    ArrayList<QuestionData> arrayList ;

    String title ;
    String answer1 ;
    String answer2 ;
    String answer3 ;
    String answer4 ;
    int patternId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamelevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        module = new ViewModelProvider(this).get(GameViewModule.class);
        module.getAllQuestions().observe(this, new Observer<List<QuestionData>>() {
            @Override
            public void onChanged(List<QuestionData> questionData) {

                arrayList = (ArrayList<QuestionData>) questionData;

                for (int i = 0; i < arrayList.size(); i++) {

                    title = arrayList.get(i).getTitle();
                    answer1 = arrayList.get(i).getAnswer1();
                    answer2 = arrayList.get(i).getAnswer2();
                    answer3 = arrayList.get(i).getAnswer3();
                    answer4 = arrayList.get(i).getAnswer4();
                    patternId = arrayList.get(i).getPatternId();
                }
            }
        });

      //  Toast.makeText(this, title, Toast.LENGTH_SHORT).show();


        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

       // if(patternId == 2){
            fragmentArrayList.add(ChooseFragment.newInstance(title , answer1 , answer2 , answer3 , answer4));
       // }
       // if(patternId == 3){
            fragmentArrayList.add(Complete_Question_Fragment.newInstance(title));
      //  }

      //  if(patternId == 1){
            fragmentArrayList.add(TrueOrFalseQuestion.newInstance(title));
     //   }

        QuestionAdapter adapter = new QuestionAdapter(this , fragmentArrayList);

        binding.viewPager.setAdapter(adapter);

    }

}