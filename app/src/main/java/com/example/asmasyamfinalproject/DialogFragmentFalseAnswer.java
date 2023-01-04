package com.example.asmasyamfinalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DialogFragmentFalseAnswer extends DialogFragment {


    private static final String ARG_PARAM1 = "hint";

    // TODO: Rename and change types of parameters
    private String hint;

    public DialogFragmentFalseAnswer() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DialogFragmentFalseAnswer newInstance(String hint) {
        DialogFragmentFalseAnswer fragment = new DialogFragmentFalseAnswer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, hint);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hint = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_false_answer, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
         super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("False Answer");
        builder.setMessage(hint);
        builder.setIcon(R.drawable._a4130c1c186f0f470b1827855886c9f);


        return builder.create();

    }
}