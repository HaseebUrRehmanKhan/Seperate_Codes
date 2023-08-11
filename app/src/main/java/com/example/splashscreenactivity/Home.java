package com.example.splashscreenactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView data;
    Button btn,custombtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn = findViewById(R.id.btn_show_alert);
        custombtn=findViewById(R.id.btn_custom_alert);

        Intent i = getIntent();
        String message = "Email: " + i.getStringExtra("email") + "\n Password: " + i.getStringExtra("paswd");
        data = findViewById(R.id.show);
        data.setText(message);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Home.this);
                dialog.setIcon(R.drawable.delete);
                dialog.setMessage("Do you really want to delete this?");
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.setText("");
                        Toast.makeText(Home.this,"Text Deleted Successfully",Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.show();
            }
        });

       custombtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               data.setText("Welcome Buddy");
               Dialog dialog=new Dialog(Home.this);
               dialog.setContentView(R.layout.custom_dialog_layout);
               dialog.setCancelable(false);
               Button ok = dialog.findViewById(R.id.btn_ok);
               ok.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });

               dialog.show();
           }
       });

        try {
            AlertDialog alert = new AlertDialog.Builder(Home.this).create();
            alert.setTitle("Terms and Conditions");
            alert.setIcon(R.drawable.info);
            alert.setMessage("Have you read terms and conditions");
           alert.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   Toast.makeText(Home.this,"you can proceed now",Toast.LENGTH_LONG).show();
               }
           });
            alert.show();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}