package com.example.asmasyamfinalproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmasyamfinalproject.R;
import com.example.asmasyamfinalproject.databinding.FragmentChooseBinding;


public class Complete_Question_Fragment extends Fragment {


    private static final String ARG_PARAM1 = "title";

    // TODO: Rename and change types of parameters
    private String title;

    public Complete_Question_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Complete_Question_Fragment newInstance(String title) {
        Complete_Question_Fragment fragment = new Complete_Question_Fragment();
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

        FragmentChooseBinding binding = FragmentChooseBinding.inflate(inflater , container , false);

        binding.textQuestion.setText(title);

        return binding.getRoot();
    }
}