package com.example.asmasyamfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asmasyamfinalproject.Class.AdapterClass;
import com.example.asmasyamfinalproject.Class.DataOfLevel;
import com.example.asmasyamfinalproject.Class.GameViewModule;
import com.example.asmasyamfinalproject.Class.Listener;
import com.example.asmasyamfinalproject.databinding.ActivityStartPlayBinding;

import java.util.ArrayList;
import java.util.List;

public class StartPlayActivity extends AppCompatActivity implements Listener {

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

                adapter = new AdapterClass(arrayList , StartPlayActivity.this , StartPlayActivity.this);

                binding.RecyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager lm = new LinearLayoutManager(StartPlayActivity.this , RecyclerView.VERTICAL ,
                        false);
                binding.RecyclerView.setLayoutManager(lm);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                startActivity(new Intent(StartPlayActivity.this , ProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnClick(int position) {

        int levelNo = arrayList.get(position).getLevelNo();
        Intent intent = new Intent(StartPlayActivity.this , GameLevels.class );
        intent.putExtra("levelNo" , levelNo);
        startActivity(intent);
    }
}