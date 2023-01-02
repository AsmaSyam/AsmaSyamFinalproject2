package com.example.asmasyamfinalproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmasyamfinalproject.R;
import com.example.asmasyamfinalproject.databinding.FragmentChooseBinding;
import com.example.asmasyamfinalproject.databinding.FragmentTrueOrFalseQuestionBinding;


public class TrueOrFalseQuestion extends Fragment {


    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM7 = "levelNo";
    private static final String ARG_PARAM8 = "puzzleNo";

    // TODO: Rename and change types of parameters
    private String title;
    private int levelNo;
    private int puzzleNo;

    public TrueOrFalseQuestion() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrueOrFalseQuestion newInstance(String title , int patternId , int levelNo , int puzzleNo) {
        TrueOrFalseQuestion fragment = new TrueOrFalseQuestion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putInt(ARG_PARAM7, levelNo);
        args.putInt(ARG_PARAM8, puzzleNo);
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

        return binding.getRoot();
    }
}