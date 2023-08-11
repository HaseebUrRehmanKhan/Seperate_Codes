package com.example.splashscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
TextInputLayout username,password;
Button btnlogin;
String name,pswd;
EditText un,ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnlogin);
        un=username.getEditText();
        ps=password.getEditText();

        un.addTextChangedListener(logintextwatcher);
        ps.addTextChangedListener(logintextwatcher);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.equals("ellisa723@gmail.com") && pswd.equals("1234567890"))
                {
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    intent.putExtra("email",name);
                    intent.putExtra("paswd",pswd);
                    startActivity(intent);
                }
            }
        });

    }
    private TextWatcher logintextwatcher= new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
           name=un.getText().toString().trim();
           pswd=ps.getText().toString().trim();
           btnlogin.setEnabled(!name.isEmpty() && !pswd.isEmpty());
    }

        @Override
        public void afterTextChanged(Editable s) {

    }
    };
}