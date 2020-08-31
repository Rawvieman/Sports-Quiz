package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz_questions";
    private static final int DATABSE_VERSION = 1;

    private SQLiteDatabase db;
    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionsTable.Table_name + "( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.column_question + " TEXT, "+
                QuestionsTable.column_option1 + " TEXT, " +
                QuestionsTable.column_option2 + " TEXT, " +
                QuestionsTable.column_option3 + " TEXT, " +
                QuestionsTable.column_option4 + " TEXT, " +
                QuestionsTable.answer + " INTEGER, " +
                QuestionsTable.topic + " TEXT "+ ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.Table_name);
        onCreate(db);
    }
    private  void fillQuestionsTable(){

        //motoGp quesstions
        Question q1 = new Question("Who has most wins in MotoGP", "Valentino Rossi", "Jorge Lorenzo", "Marc Marquez", "Dani Pedrosa", 1, "MotoGP");
        addQuestion(q1);
        Question q2 = new Question("Who has most number of podiums in MotoGP", "Marc Marquez", "Jorge Lorenzo", "Valention Rossi", "Maverick Vinales", 3, "MotoGP");
        addQuestion(q2);
        Question q3 = new Question("Which is the most sucessful constructor in MotoGP", "Yamaha", "Honda", "Ducati", "Suzuki", 2, "MotoGP");
        addQuestion(q3);
        Question q4 = new Question("Which rider has won a championship with non factory team", "Marc Marquez", "Valention Rossi", "Jorge Lorenzo", "Casey Stoner", 2, "MotoGP");
        addQuestion(q4);
        Question q5 = new Question("Who is the last Ducati world champion", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 4, "MotoGP");
        addQuestion(q5);
        Question q6 = new Question("Who has most number of pole positions in MotoGP", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 2, "MotoGP");
        addQuestion(q6);
        Question q7 = new Question("Who is the last Yamaha world champion", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 3, "MotoGP");
        addQuestion(q7);
        Question q8 = new Question("Who is the last Honda world champion", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 2, "MotoGP");
        addQuestion(q8);
        Question q9 = new Question("Which rider has most wins for Ducati", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 4, "MotoGP");
        addQuestion(q9);
        Question q10 = new Question("Who is current tyre supplier for MotoGP", "Michelin", "Bridgestone", "Dunlop", "Pirelli", 4, "MotoGP");
        addQuestion(q10);
        Question q11 = new Question("Which rider has won most world championships", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 1, "MotoGP");
        addQuestion(q11);
        Question q12 = new Question("Who won 2007 MotoGP world Championship", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 4, "MotoGP");
        addQuestion(q12);
        Question q13 = new Question("Who won 2009 MotoGP world Championship", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 1, "MotoGP");
        addQuestion(q13);
        Question q14 = new Question("Who won 2012 MotoGP world Championship", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 3, "MotoGP");
        addQuestion(q14);
        Question q15 = new Question("Who won 2017 MotoGP world Championship", "Valentino Rossi", "Marc Marquez", "Jorge Lorenzo", "Casey Stoner", 2, "MotoGP");
        addQuestion(q15);

        //f1 questions
        Question q16 = new Question("Which is the most sucessfull constructor in Formula 1", "Ferrari", "Mercedes", "McClaren", "Red Bull", 1, "Formula1");
        addQuestion(q16);
        Question q17 = new Question("Which constructor won 2007 Formula 1 constructor championship", "Ferrari", "Mercedes", "McClaren", "Red Bull", 1, "Formula1");
        addQuestion(q17);
        Question q18 = new Question("Which constructor won 20017 Formula 1 constructor championship", "Ferrari", "Mercedes", "McClaren", "Red Bull", 2, "Formula1");
        addQuestion(q18);
        Question q19 = new Question("Which constructor won 2010 Formula 1 constructor championship", "Ferrari", "Mercedes", "McClaren", "Red Bull", 4, "Formula1");
        addQuestion(q19);
        Question q20 = new Question("Which constructor won 1998 Formula 1 constructor championship", "Ferrari", "Mercedes", "McClaren", "Red Bull", 3, "Formula1");
        addQuestion(q20);
        Question q21 = new Question("Which driver has most wins in Formula 1", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 2, "Formula1");
        addQuestion(q21);
        Question q22 = new Question("Which driver has most world championships", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 2, "Formula1");
        addQuestion(q22);
        Question q23 = new Question("Which driver won 2013 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 3, "Formula1");
        addQuestion(q23);
        Question q24 = new Question("Which driver won 2014 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 1, "Formula1");
        addQuestion(q24);
        Question q25 = new Question("Which driver won 2003 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 2, "Formula1");
        addQuestion(q25);
        Question q26 = new Question("Which driver won 2013 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 3, "Formula1");
        addQuestion(q26);
        Question q27 = new Question("Which driver won 2006 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 4, "Formula1");
        addQuestion(q27);
        Question q28 = new Question("Which driver won 2007 world championship", "Kimi Raikkonen", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 1, "Formula1");
        addQuestion(q28);
        Question q29 = new Question("Which driver won 2009 world championship", "Jenson Button", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 1, "Formula1");
        addQuestion(q29);
        Question q30 = new Question("Which driver won 2010 world championship", "Lewis Hamilton", "Michale Schumacher", "Sebastian vettel", "Fernando Alonso", 3, "Formula1");
        addQuestion(q30);

        //football questions
        Question q31= new Question("Which country has won most world cups", "Brazil", "Germany", "Italy", "France", 1, "Football");
        addQuestion(q31);
        Question q32= new Question("Which club has won most number of laliga", "Barcelona", "Real Madrid", "Atletico Madrid", "Sevilla", 2, "Football");
        addQuestion(q32);
        Question q33= new Question("Which club has won most number of Champions league", "Barcelona", "Real Madrid", "Liverpool", "Manchester United", 2, "Football");
        addQuestion(q33);
        Question q34= new Question("Which club has won most number of premier league", "Liverpool", "Arsenal", "Manchester united", "chelsea", 1, "Football");
        addQuestion(q34);
        Question q35= new Question("Which club has won most number of serie A", "AC Milan", "Inter Milan", "Napoli", "Juventus", 4, "Football");
        addQuestion(q35);
        Question q36= new Question("Which player has won most number of balon d'or", "Cristiano Ronaldo", "Lionel Messi", "Ronaldinho", "Zinedine Zidane", 2, "Football");
        addQuestion(q36);
        Question q37= new Question("Who has scored the most goals in World Cup tournament history?", "Ronaldo", "Messi", "Klose", "Beckham", 3, "Football");
        addQuestion(q37);
        Question q38= new Question("Who is the only player to have won the World Cup on three occasions?", "Ronaldo", "Messi", "Klose", "Pele", 4, "Football");
        addQuestion(q38);
        Question q39= new Question("How many world cup finals have been won on a penalty shootout?", "1", "2", "3", "4", 2, "Football");
        addQuestion(q39);
        Question q40= new Question("which is the only club to win club of the century?", "Real Madrid", "Barcelona", "Manchester United", "AC Milan", 1, "Football");
        addQuestion(q40);
        Question q41= new Question("which is the only club to go undefeated in a premier league season", "Arsenal", "Liverpool", "Manchester United", "Chelsea", 1, "Football");
        addQuestion(q41);
        Question q42= new Question("Which player scored the fastest hat-trick in the Premier League?", "Ronaldo", "Salah", "Hennry", "Mane", 4, "Football");
        addQuestion(q42);
        Question q43= new Question("Which player scored the fastest hat-trick in the Premier League?", "Ronaldo", "Salah", "Hennry", "Mane", 4, "Football");
        addQuestion(q43);
        Question q44= new Question("Which country won the first ever World Cup in 1930?", "Brazil", "Germany", "Italy", "Uruguay", 4, "Football");
        addQuestion(q44);
        Question q45= new Question("Which country has appeared in three World Cup finals, but never won the competition?", "Brazil", "Germany", "Netherlands", "Uruguay", 3, "Football");
        addQuestion(q45);

        //cricket
        Question q46= new Question("Which country has won most world cups", "Australia", "England", "West Indies", "India", 1, "Cricket");
        addQuestion(q46);
        Question q47= new Question("The distance between the popping crease and the bowling crease is:", "10 feet", "5 feet", "4 feet", "2 feet", 3, "Cricket");
        addQuestion(q47);
        Question q48= new Question("Which national team are called “Baggy Greens”?", "Australia", "England", "West Indies", "India", 1, "Cricket");
        addQuestion(q48);
        Question q49= new Question("What was total number of matches played in the 1975 World Cup?", "10", "20", "15", "7", 3, "Cricket");
        addQuestion(q49);
        Question q50= new Question("Which country won first world cup", "Australia", "England", "West Indies", "India", 3, "Cricket");
        addQuestion(q50);
        Question q51= new Question("How many times Chennai Super Kings won the IPL?", "1", "2", "3", "4", 3, "Cricket");
        addQuestion(q51);
        Question q52= new Question("Which national team is nicknamed “The Proteas” or “The Springboks”?", "Australia", "England", "South Africa", "India", 3, "Cricket");
        addQuestion(q52);
        Question q53= new Question("Which country has played the maximum number of one day matches?", "Australia", "England", "South Africa", "India", 1, "Cricket");
        addQuestion(q53);
        Question q54= new Question("Which Australian city has a cricket ground called the Oval?", "Sydney", "Perth", "Melbourne", "Brisbane", 1, "Cricket");
        addQuestion(q54);
        Question q55= new Question("Who is the only batsman to have hit a century in each innings of a Test thrice?", "Sunil Gavaskar", "MS Dhoni", "AB Devillers", "Steve Smith", 1, "Cricket");
        addQuestion(q55);
        Question q56= new Question("Who does the best batting average in a test career belong?", "Sunil Gavaskar", "Don Bradman", "AB Devillers", "Steve Smith", 2, "Cricket");
        addQuestion(q56);
        Question q57= new Question("Who bowled the first ball of the 2019 Ashes series?", "Sunil Gavaskar", "James Anderson", "AB Devillers", "Steve Smith", 2, "Cricket");
        addQuestion(q57);
        Question q58= new Question("Who is the first batsman to cross 10000 runs in Tests?", "Sunil Gavaskar", "MS Dhoni", "AB Devillers", "Steve Smith", 1, "Cricket");
        addQuestion(q58);
        Question q59= new Question("The first Caribbean cricketer to be knighted was:", "Frank Worrell.", "MS Dhoni", "AB Devillers", "Steve Smith", 1, "Cricket");
        addQuestion(q59);
        Question q60= new Question("How many minutes before play should the umpires take the field?", "1", "2", "3", "5", 4, "Cricket");
        addQuestion(q60);

        //basketball
        Question q61= new Question("Who invented the game in 1891?", "James Naismith", "Sweet Georgia Brown", "Kareem Abdul-Jabbar", "Dennis Rodman", 1, "Basketball");
        addQuestion(q61);
        Question q62= new Question("How many players in total are on a basketball court at the same time?", "11", "10", "22", "15", 2, "Basketball");
        addQuestion(q62);
        Question q63= new Question("The United States men's Olympic basketball team, nicknamed the Dream Team, competed in which year at the Olympics?", "1994", "1992", "2002", "2015", 2, "Basketball");
        addQuestion(q63);
        Question q64= new Question("In feet, what is the height of a basketball rim?", "19", "12", "20", "10", 4, "Basketball");
        addQuestion(q64);
        Question q65= new Question("In feet, what is the height of a basketball rim?", "19", "12", "20", "10", 4, "Basketball");
        addQuestion(q65);
        Question q66= new Question("What is it called when a player from either team retrieves the ball and gains possession after a missed shot?", "unbound", "rebound", "nobound", "air bound", 2, "Basketball");
        addQuestion(q66);
        Question q67= new Question("Which player is the only one ever to score a record 100 points in an NBA game?", "Kobe Bryant", "Wilt Chamberlin", "Larry Bird", "Dennis Rodman", 2, "Basketball");
        addQuestion(q67);
        Question q68= new Question("Which European country won silver medals at the 1984, 2008, and 2012 Olympics, and a bronze in 2016?", "Spain", "France", "Italy", "Germany", 1, "Basketball");
        addQuestion(q68);
        Question q69= new Question("In 1999, which Boston Celtic player ranked number 30 in ESPN's Sports Century's 50 Greatest Athletes of the 20th century?", "Kobe Bryant", "Wilt Chamberlin", "Larry Bird", "Dennis Rodman", 3, "Basketball");
        addQuestion(q69);
        Question q70= new Question("Who, having played his entire 20-year career with the Lakers, became the oldest player to score 60 or more points in a game at 37 years of age in 2016?", "Kobe Bryant", "Wilt Chamberlin", "Larry Bird", "Dennis Rodman", 1, "Basketball");
        addQuestion(q70);
        Question q71= new Question("Who was known for his fierce defensive and rebounding abilities, and was nicknamed 'the worm'?", "Dennis Rodman", "Wilt Chamberlin", "Larry Bird", "Dennis Rodman", 1, "Basketball");
        addQuestion(q71);
        Question q72= new Question("Who won the National Basketball Association Most Valuable Player Award (MVP) in 2009, 2010, 2012, and 2013?", "Dennis Rodman", "Wilt Chamberlin", "Larry Bird", "LeBron James", 4, "Basketball");
        addQuestion(q72);
        Question q73= new Question("Which small European country, with a population of under 3 million, is a traditional force of the sport in Europe?", "Ukraine", "France", "Lithuania", "Ajerbaijan", 3, "Basketball");
        addQuestion(q73);
        Question q74= new Question("Who won the NBA's Most Valuable Player a record six times, between 1971 and 1980, while playing for the Milwaukee Bucks and the Los Angeles Lakers?", "Kobe Bryant", "Wilt Chamberlin", "Kareem Abdul-Jabbar", "Dennis Rodman", 3, "Basketball");
        addQuestion(q74);
        Question q75= new Question("In the UK, which city is home to the British Basketball League's head offices, and also won the league in 2016 and 2017?", "London", "Licester", "Manchester", "Brighton", 2, "Basketball");
        addQuestion(q75);
    }
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.column_question, question.getQuestion());
        cv.put(QuestionsTable.column_option1, question.getOption1());
        cv.put(QuestionsTable.column_option2, question.getOption2());
        cv.put(QuestionsTable.column_option3, question.getOption3());
        cv.put(QuestionsTable.column_option4, question.getOption4());
        cv.put(QuestionsTable.answer, question.getAnswer());
        cv.put(QuestionsTable.topic, question.getTopic());

        db.insert(QuestionsTable.Table_name, null, cv);
    }
    public List<Question> getAllQuestion(String key){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionsTable.Table_name + " WHERE topic = '" + key + "'" , null);
        if (c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.column_question)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.column_option1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.column_option2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.column_option3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.column_option4)));
                question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.answer)));
                question.setTopic(c.getString(c.getColumnIndex(QuestionsTable.topic)));
                questionList.add(question);
            }while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
