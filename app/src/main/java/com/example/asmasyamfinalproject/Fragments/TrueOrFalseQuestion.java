package com.example.asmasyamfinalproject.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asmasyamfinalproject.ListenerDialog;
import com.example.asmasyamfinalproject.databinding.FragmentTrueOrFalseQuestionBinding;


public class TrueOrFalseQuestion extends Fragment {

    public interface OnSendData{
        void sendDataTrueOrFalse(int Score , int gameCount, int rightGameCount , int wrongGameCount);
        void OnClickSkip();
        void OnDuration();

    }

    ListenerDialog listenerDialog ;



    OnSendData onSendData ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onSendData = (TrueOrFalseQuestion.OnSendData) context;
        listenerDialog = (ListenerDialog) context;
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


    public TrueOrFalseQuestion() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrueOrFalseQuestion newInstance(String title , int patternId , int levelNo , int puzzleNo
            , String trueAnswer , int points) {
        TrueOrFalseQuestion fragment = new TrueOrFalseQuestion();
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
        FragmentTrueOrFalseQuestionBinding binding = FragmentTrueOrFalseQuestionBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(title);
        binding.levelNo.setText("LevelNo : "+String.valueOf(levelNo));
        binding.puzzleNo.setText("PuzzleNo : "+String.valueOf(puzzleNo));
        binding.levelScore.setText("Score : "+Score);

        onSendData.OnDuration();

        binding.falseAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.falseAnswer.getText().toString().equals(trueAnswer)){

                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataTrueOrFalse(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                    onSendData.OnClickSkip();
                    listenerDialog.onShowDialog();


                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataTrueOrFalse(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                    listenerDialog.onShowDialogFalseAnswer();
                    onSendData.OnClickSkip();

                }
            }
        });

        binding.trueAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.trueAnswer.getText().toString().equals(trueAnswer)){

                    Score = Score + points ;
                    binding.levelScore.setText("Score : "+Score);
                    rightGameCount  = rightGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataTrueOrFalse(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "True Answer", Toast.LENGTH_SHORT).show();
                    onSendData.OnClickSkip();
                    listenerDialog.onShowDialog();


                }else {
                    wrongGameCount  = wrongGameCount + 1 ;
                    gameCount = gameCount + 1 ;
                    onSendData.sendDataTrueOrFalse(Score , gameCount , rightGameCount , wrongGameCount);
                    Toast.makeText(getContext(), "False Answer", Toast.LENGTH_SHORT).show();
                    listenerDialog.onShowDialogFalseAnswer();
                    onSendData.OnClickSkip();

                }
            }
        });

        binding.buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Score = Score - 3 ;
                onSendData.sendDataTrueOrFalse(Score , gameCount , rightGameCount , wrongGameCount);

                onSendData.OnClickSkip();

            }
        });

        return binding.getRoot();
    }
}