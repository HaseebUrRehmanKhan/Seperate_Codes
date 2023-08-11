package com.example.splashscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i=getIntent();
        String message="Email: "+i.getStringExtra("email")+"\n Password: "+i.getStringExtra("paswd");
        data=findViewById(R.id.show);
        data.setText(message);
    }
}