package com.thedesignerx.saim.new_message_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    Button _btnReg,buttonLogin;
    EditText _etEmail, _etUsername, _etPassword, _etConfirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        _etEmail = (EditText) findViewById(R.id.editTextUsername);
        _etEmail.setText("saaim92@gmail.com");

        _etUsername = (EditText) findViewById(R.id.editText5);
        _etUsername.setText("saaim92");

        _etPassword = (EditText) findViewById(R.id.editText4);
        _etPassword.setText("saaim92");

        _etConfirmpassword = (EditText) findViewById(R.id.editTextPassword);
        _etEmail.setText("saaim92");

        _btnReg = (Button) findViewById(R.id.button7);
        buttonLogin = (Button) findViewById(R.id.button6);
//        _btnReg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = _etEmail.getText().toString();
//                String username = _etUsername.getText().toString();
//                String password = _etPassword.getText().toString();
//                String confirmpassword = _etConfirmpassword.getText().toString();
//
//                String method = "register";
//                BackGroundTask backgroundTask = new BackGroundTask(getApplicationContext());
//                backgroundTask.execute(method, email, username, password, confirmpassword);
//                finish();
//            }
//        });
        _btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Register();
            }
        });

    }
    public void Register() {
        RegistrationsRequest registrationsRequest = new RegistrationsRequest();
        registrationsRequest.setEmail(_etEmail.getText().toString());
        registrationsRequest.setUsername(_etUsername.getText().toString());
        registrationsRequest.setPassword(_etPassword.getText().toString());
        registrationsRequest.setConfirmpassword(_etConfirmpassword.getText().toString());
        Call<RegistrationsResponse> registrationsResponseCall = ApiClient.getApiInterfaceRegister().getRegister(registrationsRequest);

        registrationsResponseCall.enqueue(new Callback<RegistrationsResponse>() {
            @Override
            public void onResponse(@NotNull Call<RegistrationsResponse> call, @NotNull Response<RegistrationsResponse> response) {
                if (response.isSuccessful()) {
                    RegistrationsResponse registrationsResponse = response.body();
                    // if (registrationsResponse != null) {
                    //     if (registrationsResponse.getCode() == 200) {
                    //         Toast.makeText(register.this, "successfull", Toast.LENGTH_LONG).show();
                    //      } else {
                    //          Toast.makeText(register.this, "False", Toast.LENGTH_LONG).show();
                    //      }
                    //    }
                } else {
                    Toast.makeText(register.this, "Not Login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<RegistrationsResponse> call, @NotNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}
