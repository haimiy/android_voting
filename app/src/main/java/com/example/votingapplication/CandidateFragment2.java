package com.example.votingapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class CandidateFragment2 extends Fragment {
    Button btn;
    Button btn_result;
    private static final String URL_VOTE = "http://192.168.43.52/android/vote.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_candidate2, container, false);
        btn = (Button) view.findViewById(R.id.btn_vote2);
        btn_result = (Button) view.findViewById(R.id.btn_result2);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("candidateId",2);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_VOTE+"?userId=1&candidateId=2", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                Volley.newRequestQueue(getContext()).add(stringRequest);
            }
        });
        return view;

    }
}