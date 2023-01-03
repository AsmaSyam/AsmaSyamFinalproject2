package com.example.asmasyamfinalproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asmasyamfinalproject.R;
import com.example.asmasyamfinalproject.databinding.FragmentChooseBinding;
import com.example.asmasyamfinalproject.databinding.FragmentTrueOrFalseQuestionBinding;


public class TrueOrFalseQuestion extends Fragment {


    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM7 = "levelNo";
    private static final String ARG_PARAM8 = "puzzleNo";
    private static final String ARG_PARAM9 = "trueAnswer";


    // TODO: Rename and change types of parameters
    private String title;
    private int levelNo;
    private int puzzleNo;
    private String trueAnswer;
    int Score = 0 ;


    public TrueOrFalseQuestion() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrueOrFalseQuestion newInstance(String title , int patternId , int levelNo , int puzzleNo , String trueAnswer) {
        TrueOrFalseQuestion fragment = new TrueOrFalseQuestion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putInt(ARG_PARAM7, levelNo);
        args.putInt(ARG_PARAM8, puzzleNo);
        args.putString(ARG_PARAM9, trueAnswer);
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

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTrueOrFalseQuestionBinding binding = FragmentTrueOrFalseQuestionBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(title);
        binding.levelNo.setText("LevelNo : "+String.valueOf(levelNo));
        binding.puzzleNo.setText("PuzzleNo : "+String.valueOf(puzzleNo));
        binding.levelScore.setText("Score : "+Score);

        binding.falseAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.falseAnswer.getText().toString().equals(trueAnswer)){

                    Score = Score + 1 ;
                    binding.levelScore.setText("Score : "+Score);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.trueAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.trueAnswer.getText().toString().equals(trueAnswer)){

                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }
}