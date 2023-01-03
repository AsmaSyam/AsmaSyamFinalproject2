package com.example.asmasyamfinalproject.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asmasyamfinalproject.databinding.FragmentCompleteQuestionBinding;


public class Complete_Question_Fragment extends Fragment {

    public interface OnSendData{
        void sendDataComplete(int Score , int gameCount, int rightGameCount , int wrongGameCount);
    }

      OnSendData onSendData ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onSendData = (Complete_Question_Fragment.OnSendData) context;
    }

    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM7 = "levelNo";
    private static final String ARG_PARAM8 = "puzzleNo";
    private static final String ARG_PARAM9 = "trueAnswer";
    private static final String ARG_PARAM10 = "points";



    // TODO: Rename and change types of parameters
    private String title;
    private int levelNo;
    private int puzzleNo;
    private String trueAnswer;
    int Score = 0 ;
    int points ;
    int gameCount  = 0;
    int rightGameCount = 0 ;
    int wrongGameCount = 0 ;


    public Complete_Question_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Complete_Question_Fragment newInstance(String title ,int patternId , int levelNo , int puzzleNo
            , String trueAnswer , int points) {
        Complete_Question_Fragment fragment = new Complete_Question_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putInt(ARG_PARAM7, levelNo);
        args.putInt(ARG_PARAM8, puzzleNo);
        args.putString(ARG_PARAM9, trueAnswer);
        args.putInt(ARG_PARAM10, points);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            levelNo = getArguments().getInt(ARG_PARAM7);
            puzzleNo = getArguments().getInt(ARG_PARAM8);
            trueAnswer = getArguments().getString(ARG_PARAM9);
            points = getArguments().getInt(ARG_PARAM10);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentCompleteQuestionBinding binding = FragmentCompleteQuestionBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(title);
        binding.levelNo.setText("LevelNo : "+String.valueOf(levelNo));
        binding.puzzleNo.setText("PuzzleNo : "+String.valueOf(puzzleNo));
        binding.levelScore.setText("Score : "+Score);


        if(binding.answer.getText().toString().equals(trueAnswer)){

            Score = Score + points ;
            binding.levelScore.setText("Score : "+Score);
            rightGameCount  = rightGameCount + 1 ;
            gameCount = gameCount + 1 ;
            onSendData.sendDataComplete(Score , gameCount ,rightGameCount ,wrongGameCount);
            Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();

        }else {
            wrongGameCount  = wrongGameCount + 1 ;
            gameCount = gameCount + 1 ;
            onSendData.sendDataComplete(Score , gameCount ,rightGameCount ,wrongGameCount);
            Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
        }

        binding.buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Score = Score - 3 ;
                onSendData.sendDataComplete(Score , gameCount ,rightGameCount ,wrongGameCount);

            }
        });


        return binding.getRoot();
    }
}