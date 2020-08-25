package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class CreateAccActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText full_name;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private static final String URL_CREATE_ACCOUNT = "http://192.168.43.52/android/create_account.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);


        full_name = findViewById(R.id.text_full_name);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_psw);
        confirm_password = findViewById(R.id.text_Cpsw);
        
        Button btn = findViewById(R.id.btn_create_acc);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_create_acc){
            String name = full_name.getText().toString().trim();
            String email = this.email.getText().toString().trim();
            String password = this.password.getText().toString().trim();
            String c_password = confirm_password.getText().toString().trim();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || c_password.isEmpty()){
                Toast.makeText(this, "Pleas fill all details", Toast.LENGTH_SHORT).show();
            }
            else if (!password.equals(c_password)){
                Toast.makeText(this, "Password dose not match", Toast.LENGTH_SHORT).show();
            }
            else {
                createAccount(name,email,password);
//                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
            }

        }
    }

    private void createAccount(final String name, final String email, final String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CREATE_ACCOUNT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CreateAccActivity.this, "Insertion Success ", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error "+error);

                Toast.makeText(CreateAccActivity.this, "Insertion fail"+error, Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            public Map<String, String> getParams()  {
                Map<String, String> params = new HashMap<>();
                params.put("full_name", name);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}