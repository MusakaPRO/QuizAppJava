package com.example.ispit.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    //DB version, table and database name
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE = "quiztable";

    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
    }

    private void addQuestions() {
        Question q1 = new Question("Who developed C languages?", "Ken Thomson", "Dennis Ritchie", "Von Neuman", "Dennis Ritchie");
        this.addQuestionToDB(q1);
        Question q2 = new Question("Which of the following is not a storage class?", "Auto", "Register", "Static", "Auto");
        this.addQuestionToDB(q2);
        Question q3 = new Question("What is the length null string?", "3", "2", "0", "0");
        this.addQuestionToDB(q3);
        Question q4 = new Question("Which of the following functions can be used to increase the size of dynamically allocated array?", "calloc()", "realloc()", "memadjust()", "realloc()");
        this.addQuestionToDB(q4);
        Question q5 = new Question("A variable declared with ____ modifier caan retain its value during function calls.", "static", "extern", "volatile", "static");
        this.addQuestionToDB(q5);
        Question q6 = new Question("Pointers can be used to achieve", "call by reference", "call by procedure", "call by function", "call by function");
        this.addQuestionToDB(q6);
        Question q7 = new Question("A structure is", "Scalar data type", "Primitive data type", "Derived data type", "Derived data type");
        this.addQuestionToDB(q7);
        Question q8 = new Question("Every C program has access to which of the following files?", "int", "char", "float", "int");
        this.addQuestionToDB(q8);
        Question q9 = new Question("Every C program has access to which of the following files?", "stdin", "stdout", "all of above", "all of above");
        this.addQuestionToDB(q9);
        Question q10 = new Question("How much memory is required to store a value of type double?", "8 bytes", "4 bytes", "10 bytes", "8 bytes");
        this.addQuestionToDB(q10);
        Question q11 = new Question("Which of the following is not a valid storage class?", "static", "register", "automatic", "automatic");
        this.addQuestionToDB(q11);
        Question q12 = new Question("Which of the following is not a reserved word in C langauge?", "switch", "doo", "goto", "doo");
        this.addQuestionToDB(q12);
        Question q13 = new Question("The mechanism by which the data and functions are bound together within an objecs is called as ?", "Encapsulation", "Overloading", "Overriding", "Encapsulation");
        this.addQuestionToDB(q13);
        Question q14 = new Question("The group of data and operations together are known as ?", "Function", "Object", "Structure", "Object");
        this.addQuestionToDB(q14);
        Question q15 = new Question("The derived class are ........ packed.?", "cover", "completely", "power", "power");
        this.addQuestionToDB(q15);
        Question q16 = new Question("Which of the followings is correct for a function definition along with storage-class specifier in C language?", "int fun(static int arg)", "int fun(register int arg)", "All of the above are correct.", "int fun(register int arg)");
        this.addQuestionToDB(q16);
        Question q17 = new Question("Which of the following is not a standard C Library?", "errno.h", "retarg.h", "signal.h", "retarg.h");
        this.addQuestionToDB(q17);
        Question q18 = new Question("Which of the following cannot be static in C?", "Variables", "Functions", "None of the mentioned", "None of the mentioned");
        this.addQuestionToDB(q18);
        Question q19 = new Question("Property of external variable to be accessed by any source file is called by C90 standard as", "external linkage", "external scope", "global scope", "external linkage");
        this.addQuestionToDB(q19);
        Question q20 = new Question("Default storage class if not any is specified for a local variable, is auto ?", "true", "false", "None of the mentioned", "true");
        this.addQuestionToDB(q20);

    }

    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        dbase.insert(DB_TABLE, null, values);
    }

    public List <Question> getAllQuestions(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }
}
