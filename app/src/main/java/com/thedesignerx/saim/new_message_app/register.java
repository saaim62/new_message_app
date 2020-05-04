package com.thedesignerx.saim.new_message_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {

    Button _btnReg,buttonLogin;
    EditText _etEmail, _etUsername, _etPassword, _etConfirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        _etEmail = (EditText) findViewById(R.id.editText);
        _etUsername = (EditText) findViewById(R.id.editText5);
        _etPassword = (EditText) findViewById(R.id.editText4);
        _etConfirmpassword = (EditText) findViewById(R.id.editText2);
        _btnReg = (Button) findViewById(R.id.button7);
        buttonLogin = (Button) findViewById(R.id.button6);
        _btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _etEmail.getText().toString();
                String username = _etUsername.getText().toString();
                String password = _etPassword.getText().toString();
                String confirmpassword = _etConfirmpassword.getText().toString();

                String method = "register";
                BackGroundTask backgroundTask = new BackGroundTask(getApplicationContext());
                backgroundTask.execute(method, email, username, password, confirmpassword);
                finish();
            }
        });

    }
}
