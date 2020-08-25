package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
     private EditText text_email;
     private EditText text_password;
     private static final String URL_CREATE_ACCOUNT = "http://192.168.43.52/android/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_email = findViewById(R.id.text_email);
        text_password = findViewById(R.id.text_psw);

        Button btn = findViewById(R.id.buttonLogin);
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
        if (v.getId() == R.id.buttonLogin){
            String email = text_email.getText().toString().trim();
            String password = text_password.getText().toString().trim();
            if(password.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Please Enter your email or password", Toast.LENGTH_SHORT).show();
            }
            else {
                login(email,password);
        }}
    }

    private void login(final String email, final String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CREATE_ACCOUNT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Login Successful")){
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error "+error);

                Toast.makeText(LoginActivity.this, "Insertion fail"+error, Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            public Map<String, String> getParams()  {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}