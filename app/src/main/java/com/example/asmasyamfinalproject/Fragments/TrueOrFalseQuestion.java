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

    // TODO: Rename and change types of parameters
    private String title;

    public TrueOrFalseQuestion() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrueOrFalseQuestion newInstance(String title) {
        TrueOrFalseQuestion fragment = new TrueOrFalseQuestion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTrueOrFalseQuestionBinding binding = FragmentTrueOrFalseQuestionBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(title);

        return binding.getRoot();
    }
}