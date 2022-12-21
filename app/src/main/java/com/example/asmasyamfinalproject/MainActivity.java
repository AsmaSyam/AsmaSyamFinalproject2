package com.example.asmasyamfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String fileName = readFromAssets("jsonData.json");

        parseTheJson(fileName);

    }

    private void parseTheJson(String string) {
        // هنا رح اعمل البارس


        JSONArray jsonArray = new JSONArray();


    }

    private String readFromAssets(String fileName) {
        String string = "";
        try {
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] byteObject = new byte[size];
            inputStream.read(byteObject);
            inputStream.close();
            string = new String(byteObject , "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return string ;

    }


}