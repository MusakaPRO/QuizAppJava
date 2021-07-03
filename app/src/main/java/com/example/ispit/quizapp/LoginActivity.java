package com.example.ispit.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    TextView utx1,uterr;
    Button buttonS;
    String login;
    int llenght = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        TextView utx1 = (TextView) findViewById(R.id.usernametext);
        final TextView uterr = (TextView) findViewById(R.id.usernameerror);
        utx1.setBackgroundColor(0XDDC4C4);
        buttonS = (Button)findViewById(R.id.start);



        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                login = username.getText().toString();

                if(login.isEmpty()){
                    uterr.setVisibility(View.VISIBLE);
                }
                else{

                    Log.d("Username", "Your username(LOGIN): "+login);
                    Intent start = new Intent(LoginActivity.this,MainActivity.class);
                    start.putExtra("username", String.valueOf(login));
                    uterr.setVisibility(View.INVISIBLE);
                    startActivity(start);
                }

            }
        });
    }




  public void start(View view) {


//String login=this.username.getText().toString();

        Intent start = new Intent(LoginActivity.this,MainActivity.class);
        start.putExtra("username", String.valueOf(login));
        Log.d("Username", "Your username: "+login);
        startActivity(start);


    }
}