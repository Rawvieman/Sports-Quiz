package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView line = findViewById(R.id.textView6);
        TextView scoretv = findViewById(R.id.textView7);
        Intent intents = getIntent();
        int score = getIntent().getExtras().getInt("score");
        if(score > 0){
            line.setText("Your score for last quiz is:");
            scoretv.setText(Integer.toString(score));
        }
    }
}