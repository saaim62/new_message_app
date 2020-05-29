package com.thedesignerx.saim.new_message_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Login extends AppCompatActivity {

    TextView textView;
    Button buttonLogin;
    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.button6);

        txtUsername = findViewById(R.id.editTextUsername);
   //     txtUsername.setText("saaim");
        txtPassword = findViewById(R.id.editTextPassword);
     //   txtPassword.setText("123");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtUsername.getText().toString()) || TextUtils.isEmpty(txtPassword.getText().toString())) {
                    Toast.makeText(Login.this, "username / password required", Toast.LENGTH_LONG).show();

                } else {
                    login();
                }
            }
        });
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = txtUsername.getText().toString().trim();
//                String password = txtPassword.getText().toString().trim();
//                String method = "login";
//                BackGroundTaskLogin backGroundTaskLogin = new BackGroundTaskLogin(getApplicationContext());
//                backGroundTaskLogin.execute(method, username, password);
//
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(ApiInterface.BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//                Call<LoginResponse> call = apiInterface.getlogin();
//                call.enqueue(new Callback<LoginResponse>() {
//                    @Override
//                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                        LoginResponse loginResponse = response.body();
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginResponse> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//                });
//
//            }
//        });

    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(txtUsername.getText().toString());
        loginRequest.setPassword(txtPassword.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getApiInterface().getlogin(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        if (loginResponse.getCode() == 200) {
                            Toast.makeText(Login.this, "Logined", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Login.this, "False", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(Login.this, "Not Login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }


    public void text_msg6(View view) {
        textView = findViewById(R.id.textView17);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupScreen();
            }
        });
    }

    public void openSignupScreen() {
        Intent intent = new Intent(this, register.class);
         startActivity(intent);
    }

}

