package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Register extends AppCompatActivity {

    Button back = null;
    EditText username, password, confirmPassword;
    Button register = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    public void init(){
        back = (Button) findViewById(R.id.btn_back);
        register = (Button) findViewById(R.id.btn_register);
        username = (EditText) findViewById(R.id.text_usernameReg);
        password = (EditText) findViewById(R.id.text_passwordReg) ;
        confirmPassword = (EditText) findViewById(R.id.text_confirmPasswordReg);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please provide a username and password!", Toast.LENGTH_LONG).show();
                }else{
                    if(password.getText().toString().equals(confirmPassword.getText().toString())){
                        registerVolley(username.getText().toString(), password.getText().toString());
                    }else{
                        Toast.makeText(getApplicationContext(), "Password did not match!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    public void registerVolley(String username, String password){

//        final TextView textView = (TextView) findViewById(R.id.resText2);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://172.16.11.8:3000/api/register/"+username+"/"+password;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        textView.setText("Response is: "+ response);
                        Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Cannot connect to the server!\nPlease try again later.", Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    }

