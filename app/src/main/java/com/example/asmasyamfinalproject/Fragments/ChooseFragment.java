package com.example.asmasyamfinalproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmasyamfinalproject.R;
import com.example.asmasyamfinalproject.databinding.FragmentChooseBinding;


public class ChooseFragment extends Fragment {


    private static final String ARG_PARAM1 = "question";
    private static final String ARG_PARAM2 = "answer1";
    private static final String ARG_PARAM3 = "answer2";
    private static final String ARG_PARAM4 = "answer3";
    private static final String ARG_PARAM5 = "answer4";
    private static final String ARG_PARAM6 = "patternId";
    private static final String ARG_PARAM7 = "levelNo";
    private static final String ARG_PARAM8 = "puzzleNo";

    // TODO: Rename and change types of parameters
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int patternId;
    private int levelNo;
    private int puzzleNo;

    public ChooseFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChooseFragment newInstance(String question, String answer1 , String answer2
            , String answer3 , String answer4 , int patternId , int levelNo , int puzzleNo) {
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

        return binding.getRoot();
    }
}