package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = findViewById(R.id.btn_vote);
        TextView textView = findViewById(R.id.text_createAcc);
        btn.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_createAcc){
            Intent i = new Intent(this,CreateAccActivity.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btn_vote){
            Intent i1 = new Intent(this,WelcomeActivity.class);
            startActivity(i1);
        }
    }
}