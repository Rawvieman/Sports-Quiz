package com.example.quiz;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract(){}

    public  static class QuestionsTable implements BaseColumns {
        public static final  String Table_name= "quiz_questions";
        public static final  String column_question= "question";
        public static final  String  column_option1= "option1";
        public static final  String  column_option2= "option2";
        public static final  String  column_option3= "option3";
        public static final  String  column_option4= "option4";
        public static final  String  answer= "answer_no";
        public static final  String  topic= "topic";
    }
}
