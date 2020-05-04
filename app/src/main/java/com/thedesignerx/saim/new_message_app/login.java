package com.thedesignerx.saim.new_message_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView textView;
    Button buttonLogin;
    EditText txtUsername, txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.button6);
        txtUsername = findViewById(R.id.editText);
        txtPassword = findViewById(R.id.editText2);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String method = "login";
                BackGroundTaskLogin backGroundTaskLogin = new BackGroundTaskLogin(getApplicationContext());
                backGroundTaskLogin.execute(method, username, password);

            }
        });

    }


    public void text_msg6(View view) {
        textView = (TextView) findViewById(R.id.textView17);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });
    }
    public void openregister() {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }


}

