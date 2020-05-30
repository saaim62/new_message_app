package com.thedesignerx.saim.new_message_app

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thedesignerx.saim.new_message_app.ApiClient.apiInterface
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       // txtUsername.setText("saaim");
      //  txtPassword.setText("123");

        buttonLogin.setOnClickListener(View.OnClickListener {

            if (TextUtils.isEmpty(txtUsername.text.toString()) || TextUtils.isEmpty(txtPassword.text.toString())) {
                Toast.makeText(this@Login, "username / password required", Toast.LENGTH_LONG).show()
            } else {
                login()
            }
        })
    }

    private fun login() {
        val loginRequest = LoginRequest()
        loginRequest.username = txtUsername!!.text.toString()
        loginRequest.password = txtPassword!!.text.toString()
        val loginResponseCall = apiInterface.getlogin(loginRequest)
        loginResponseCall!!.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(call: Call<LoginResponse?>, response: Response<LoginResponse?>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        if (loginResponse.code == 200) {
                            Toast.makeText(this@Login, "Logined", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this@Login, "False", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(this@Login, "Not Login", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

//    fun text_msg6(view: View?) {
//        textView = findViewById(R.id.textView17)
//        textView.setOnClickListener(View.OnClickListener { openSignupScreen() })
//    }
//
//    fun openSignupScreen() {
//        val intent = Intent(this, register::class.java)
//        startActivity(intent)
//    }
}