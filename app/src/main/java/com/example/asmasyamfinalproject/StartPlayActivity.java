package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.asmasyamfinalproject.Class.AdapterClass;
import com.example.asmasyamfinalproject.Class.DataOfLevel;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.databinding.ActivityStartPlayBinding;

import java.util.ArrayList;
import java.util.List;

public class StartPlayActivity extends AppCompatActivity {

    ActivityStartPlayBinding binding ;
    AdapterClass adapter ;
    GameViewModule module ;
    ArrayList<DataOfLevel> arrayList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        module = new ViewModelProvider(this).get(GameViewModule.class);

        module.getAllLevel().observe(this, new Observer<List<DataOfLevel>>() {
            @Override
            public void onChanged(List<DataOfLevel> dataOfLevels) {

                arrayList = (ArrayList<DataOfLevel>) dataOfLevels;
            }
        });

        adapter = new AdapterClass(arrayList);

        binding.RecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(StartPlayActivity.this , RecyclerView.VERTICAL ,
                false);
        binding.RecyclerView.setLayoutManager(lm);
    }
}