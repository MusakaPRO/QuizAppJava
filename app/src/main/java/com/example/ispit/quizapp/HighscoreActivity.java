package com.example.ispit.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HighscoreActivity extends AppCompatActivity {

    String username;
    TextView usernameText,dateText;
    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        TextView scoreTxtView = (TextView) findViewById(R.id.score);
        TextView usernameText = (TextView) findViewById(R.id.userLogin);
        TextView dateText = (TextView) findViewById(R.id.date);


        username = getIntent().getStringExtra("username");

        Log.d("username", "username is..(HIGHSCOREGET)  "+username);
        usernameText.setText(username);
        Log.d("Usernametext", "UsernameText is..(HIGHSCORESET)  "+usernameText);


        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        scoreTxtView.setText(String.valueOf("Your score "+score));

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        dateText.setText(date);







    }



}