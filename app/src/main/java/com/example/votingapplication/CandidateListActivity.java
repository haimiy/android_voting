package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CandidateListActivity extends AppCompatActivity implements View.OnClickListener {
   TextView candidate1;
   TextView candidate2;
   TextView candidate3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);
        candidate1 = findViewById(R.id.candidate1);
        candidate2 = findViewById(R.id.candidate2);
        candidate3 = findViewById(R.id.candidate3);

        candidate1.setOnClickListener(this);
        candidate2.setOnClickListener(this);
        candidate3.setOnClickListener(this);

        Button btn = findViewById(R.id.btn_vote1);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        if(v.getId() == R.id.candidate1){
            fragment = new CandidateFragment();
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frag_place,fragment);
            ft.commit();
        }
        if(v.getId() == R.id.candidate2){
            fragment = new CandidateFragment2();
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frag_place,fragment);
            ft.commit();
        }
        if(v.getId() == R.id.candidate3){
            fragment = new CandidateFragment3();
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frag_place,fragment);
            ft.commit();
        }
    }
}