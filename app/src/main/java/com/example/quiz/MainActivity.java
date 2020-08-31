package com.example.quiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";
    private int score = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ImageView motogpimg = findViewById(R.id.imagemoto);
        ImageView f1img = findViewById(R.id.imagef1);
        ImageView footimg = findViewById(R.id.imagefoot);
        ImageView cricketimg = findViewById(R.id.imagecricket);
        ImageView basketimg = findViewById(R.id.imagebasket);
        motogpimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz(1);
            }
        });
        f1img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz(2);
            }
        });
        footimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz(3);
            }
        });
        cricketimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz(4);
            }
        });
        basketimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz(5);
            }
        });
        TextView viewScore = findViewById(R.id.textView2);
        viewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startQuiz(0);
            }
        });
    }
    private void startQuiz(int id){
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        if(id == 0) {
            Intent intents = new Intent(MainActivity.this, ScoreActivity.class);
            intents.putExtra("score", score);
            startActivity(intents);
        }
        if(id == 1) {
            intent.putExtra("key", "MotoGP");
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if(id == 2) {
            intent.putExtra("key", "Formula1");
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if(id == 3) {
            intent.putExtra("key", "Football");
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if(id == 4) {
            intent.putExtra("key", "Cricket");
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if(id == 5) {
            intent.putExtra("key", "Basketball");
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE){
            if(resultCode == RESULT_OK){
                score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
            }
        }
    }
}