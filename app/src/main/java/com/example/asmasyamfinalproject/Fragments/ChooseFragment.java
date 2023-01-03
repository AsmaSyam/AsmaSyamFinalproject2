package com.example.asmasyamfinalproject.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asmasyamfinalproject.databinding.FragmentChooseBinding;


public class ChooseFragment extends Fragment {

   public interface OnSendData{
        void sendDataChoose(int Score , int gameCount, int rightGameCount , int wrongGameCount);
    }

    OnSendData onSendData ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onSendData = (ChooseFragment.OnSendData) context;
    }

    private static final String ARG_PARAM1 = "question";
    private static final String ARG_PARAM2 = "answer1";
    private static final String ARG_PARAM3 = "answer2";
    private static final String ARG_PARAM4 = "answer3";
    private static final String ARG_PARAM5 = "answer4";
    private static final String ARG_PARAM6 = "patternId";
    private static final String ARG_PARAM7 = "levelNo";
    private static final String ARG_PARAM8 = "puzzleNo";
    private static final String ARG_PARAM9 = "trueAnswer";
    private static final String ARG_PARAM10 = "points";

    // TODO: Rename and change types of parameters
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int patternId;
    private int levelNo;
    private int puzzleNo;
    private String trueAnswer;
    int Score = 0;
    int points ;
    int gameCount  = 0;
    int rightGameCount = 0 ;
    int wrongGameCount = 0 ;


    public ChooseFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChooseFragment newInstance(String question, String answer1 , String answer2
            , String answer3 , String answer4 , int patternId , int levelNo , int puzzleNo , String trueAnswer , int points){
        ChooseFragment fragment = new ChooseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, question);
        args.putString(ARG_PARAM2, answer1);
        args.putString(ARG_PARAM3, answer2);
        args.putString(ARG_PARAM4, answer3);
        args.putString(ARG_PARAM5, answer4);
        args.putInt(ARG_PARAM6, patternId);
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
            question = getArguments().getString(ARG_PARAM1);
            answer1 = getArguments().getString(ARG_PARAM2);
            answer2 = getArguments().getString(ARG_PARAM3);
            answer3 = getArguments().getString(ARG_PARAM4);
            answer4 = getArguments().getString(ARG_PARAM5);
            patternId = getArguments().getInt(ARG_PARAM6);
            levelNo = getArguments().getInt(ARG_PARAM7);
            puzzleNo = getArguments().getInt(ARG_PARAM8);
            trueAnswer = getArguments().getString(ARG_PARAM9);
            points = getArguments().getInt(ARG_PARAM10);

            Log.d("question", "onCreate: " + question);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentChooseBinding binding = FragmentChooseBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(question);
        binding.buttonAnswer1.setText(answer1);
        binding.buttonAnswer2.setText(answer2);
        binding.buttonAnswer3.setText(answer3);
        binding.buttonAnswer4.setText(answer4);
        binding.levelNo.setText("LevelNo : "+String.valueOf(levelNo));
        binding.puzzleNo.setText("PuzzleNo : "+String.valueOf(puzzleNo));
        binding.levelScore.setText("Score : "+Score);

        binding.buttonAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.buttonAnswer1.getText().toString().equals(trueAnswer)){

                    // هعمل هنا اذا البوينت هيا المطلوب او غيرو بزود قيمته على Score
                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();

                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.buttonAnswer2.getText().toString().equals(trueAnswer)){

                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.buttonAnswer3.getText().toString().equals(trueAnswer)){

                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.buttonAnswer4.getText().toString().equals(trueAnswer)){

                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Score = Score - 3 ;
                onSendData.sendDataChoose(Score , gameCount , rightGameCount , wrongGameCount);


            }
        });




        return binding.getRoot();
    }
}