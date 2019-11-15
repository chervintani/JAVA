package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Home extends AppCompatActivity {
    SharedPreferences prf;
    Intent intent;
    Button logout=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    public void init(){
        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(Home.this,MainActivity.class);

        Map<String,?> keys = prf.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
//
        SharedPreferences myPrefs = this.getSharedPreferences("user_details", MODE_PRIVATE);
        String username1 = myPrefs.getString("username",null);
        String password1 = myPrefs.getString("password",null);

        if(username1 == null && password1 == null){
            System.out.println("NULL");
            startActivity(intent);
//            finish();
        }

        logout = (Button) findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "ENTERED", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
//                finish();
            }
        });
    }
}
