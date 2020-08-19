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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class CreateAccActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText full_name;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private static final String URL_CREATE_ACCOUNT = "http://192.168.43.103/class/php/uni/mo/create_account.php";
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
                Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
                try {
                    createAccount(name,email,password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
            }

        }
    }

    private void createAccount(String name,String email, String password) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("email",email);
        jsonObject.put("phone_number","+255765789809");
        jsonObject.put("password",password);
        Toast.makeText(this, "crate", Toast.LENGTH_SHORT).show();
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_CREATE_ACCOUNT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CreateAccActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CreateAccActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}