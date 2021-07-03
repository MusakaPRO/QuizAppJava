package com.example.ispit.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    private TextView loginfo;
    String username;

    int scoreFinal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        loginfo = findViewById(R.id.login);
        TextView scoreTxtView = (TextView) findViewById(R.id.score);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
        ImageView img = (ImageView)findViewById(R.id.img1);



        username = getIntent().getStringExtra("username");
        Log.d("username", "username is..(RESULT1)  "+username);
        loginfo.setText(username);


        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        ratingBar.setRating(score);
        scoreTxtView.setText(String.valueOf(score));


        if(score == 0){
            img.setImageResource(R.drawable.score_0);
        }else if(score >= 1 & score <= 3){
            img.setImageResource(R.drawable.score_1);
        }else if(score >=4 & score <=6){
            img.setImageResource(R.drawable.score_2);
        }else if(score >=7 & score <= 8){
            img.setImageResource(R.drawable.score_3);
        }else if(score == 9){
            img.setImageResource(R.drawable.score_4);
        }else if(score == 10){
            img.setImageResource(R.drawable.score_5);
        }

        scoreFinal = score;
    }

    public void highscore(View view) {

        Intent highscore = new Intent(this,HighscoreActivity.class);
        username = getIntent().getStringExtra("username");
        Log.d("username", "username is..(USERNAME2)  "+username);

        highscore.putExtra("username", String.valueOf(username));

        Bundle b = new Bundle();
        b.putInt("score",scoreFinal);
        Log.d("score", "score.(scoreIntent)  "+scoreFinal);
        highscore.putExtras(b);
        startActivity(highscore);
    }
}
