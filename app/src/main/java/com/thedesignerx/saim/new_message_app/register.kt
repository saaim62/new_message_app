//package com.thedesignerx.saim.new_message_app
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.thedesignerx.saim.new_message_app.ApiClient.apiInterfaceRegister
//import com.thedesignerx.saim.new_message_app.register
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class register : AppCompatActivity() {
//    private var _btnReg: Button? = null
//    private var buttonLogin: Button? = null
//    private var _etEmail: EditText? = null
//    private var _etUsername: EditText? = null
//    private var _etPassword: EditText? = null
//    private var _etConfirmpassword: EditText? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//        _etEmail = findViewById<View>(R.id.editTextUsername) as EditText
//
//        _etUsername = findViewById<View>(R.id.editText5) as EditText
//
//        _etPassword = findViewById<View>(R.id.editText4) as EditText
//
//        _etConfirmpassword = findViewById<View>(R.id.editTextPassword) as EditText
//
//        _btnReg = findViewById<View>(R.id.button7) as Button
//        buttonLogin = findViewById<View>(R.id.button6) as Button
//        _btnReg!!.setOnClickListener { Register() }
//    }
//
//    fun Register() {
//        val registrationsRequest = RegistrationsRequest()
//        registrationsRequest.setEmail(_etEmail!!.text.toString())
//        registrationsRequest.setUsername(_etUsername!!.text.toString())
//        registrationsRequest.setPassword(_etPassword!!.text.toString())
//        registrationsRequest.setConfirmpassword(_etConfirmpassword!!.text.toString())
//        val registrationsResponseCall = apiInterfaceRegister.getRegister(registrationsRequest)
//        registrationsResponseCall!!.enqueue(object : Callback<RegistrationsResponse?> {
//            override fun onResponse(call: Call<RegistrationsResponse?>, response: Response<RegistrationsResponse?>) {
//                if (response.isSuccessful) {
//                    val registrationsResponse = response.body()
//
//                } else {
//                    Toast.makeText(this@register, "Not Login", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<RegistrationsResponse?>, t: Throwable) {
//                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}