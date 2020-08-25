package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private static final String URL_DISPLAY_RESULT = "http://192.168.43.52/android/candidate_result.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ResultDisplay();

        t1 = findViewById(R.id.text_one);
        t2 = findViewById(R.id.text_two);
        t3 = findViewById(R.id.text_three);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_one) {
        }
        if (v.getId() == R.id.text_one) {
        }
        if (v.getId() == R.id.text_one) {
        }
    }
    public void ResultDisplay(){
    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DISPLAY_RESULT, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(ResultActivity.this, response, Toast.LENGTH_SHORT).show();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(ResultActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
        }
    });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}