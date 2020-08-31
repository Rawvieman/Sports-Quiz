package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static  final String EXTRA_SCORE = "extra";
    TextView topic;
    TextView questionTxt;
    RadioGroup rg;
    RadioButton b1;
    RadioButton b2;
    RadioButton b3;
    RadioButton b4;
    Button next;
    List<Question> questionList;
    int score = 0;
    int questionCounter;
    Question currentQuestion;
    TextView questionAnswered;
    boolean answerd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        String key= intent.getExtras().getString("key");
        topic = findViewById(R.id.textView3);
        questionTxt = findViewById(R.id.textView4);
        rg = findViewById(R.id.radioGroup2);
        b1 = findViewById(R.id.radioButton1);
        b2 = findViewById(R.id.radioButton2);
        b3 = findViewById(R.id.radioButton3);
        b4 = findViewById(R.id.radioButton4);
        next = findViewById(R.id.nextBtn);
        questionAnswered = findViewById(R.id.textView5);

       QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestion(key);
        questionCounter = 0;
        showNextQuestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answerd){
                    if(b1.isChecked() || b2.isChecked() || b3.isChecked() || b4.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void showNextQuestion(){
        rg.clearCheck();
        if (questionCounter < questionList.size()){
            currentQuestion = questionList.get(questionCounter);
            int qA = questionCounter+1;
            questionAnswered.setText(Integer.toString(qA)+" / "+Integer.toString(questionList.size()));
            topic.setText(currentQuestion.getTopic());
            questionTxt.setText(currentQuestion.getQuestion());
            b1.setText(currentQuestion.getOption1());
            b2.setText(currentQuestion.getOption2());
            b3.setText(currentQuestion.getOption3());
            b4.setText(currentQuestion.getOption4());

            questionCounter++;
            answerd = false;
        }
        else{
            finishQuiz();
        }
    }
    private void checkAnswer(){
        answerd = true;
         RadioButton bSelected = findViewById(rg.getCheckedRadioButtonId());
         int answerno = rg.indexOfChild(bSelected)+1;

         if(answerno == currentQuestion.getAnswer()){
             score++;
             Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
         }
         else Toast.makeText(QuizActivity.this, "Wrong answer", Toast.LENGTH_SHORT).show();
         showNextQuestion();
    }
    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}