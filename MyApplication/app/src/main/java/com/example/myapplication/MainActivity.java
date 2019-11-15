package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button login = null;
    EditText username, password;
    Button register = null;
    Button create = null;
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        login = (Button) findViewById(R.id.btn_login);
        create = (Button) findViewById(R.id.btn_registerPage);
        register = (Button) findViewById(R.id.btn_register);
        username = (EditText) findViewById(R.id.text_usernameReg);
        password = (EditText) findViewById(R.id.text_passwordReg);

        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        Map<String,?> keys = pref.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }

        intent = new Intent(MainActivity.this,Home.class);
//        if(pref.contains("username") && pref.contains("password")){
//            System.out.println("ENTERED");
//            startActivity(intent);
//        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please provide a username and password!", Toast.LENGTH_LONG).show();
                }else{
                volley(username.getText().toString(),password.getText().toString());
                username.setText("");
                password.setText("");
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
    
    public void volley(String username, String password){
        final String username1 = username;
        final String password1 = password;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://172.16.11.8:3000/api/login/"+username+"/"+password;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("account not found!")){
                            Toast.makeText(getApplicationContext(), "Invalid username or password!", Toast.LENGTH_LONG).show();
                        }else{
                            System.out.println(username1);
                            System.out.println(password1);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("username",username1);
                            editor.putString("password",password1);
                            editor.commit();
                            Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG).show();
//                            setContentView(R.layout.activity_home);
                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);
                        }
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