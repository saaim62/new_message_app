package com.thedesignerx.saim.new_message_app

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : Activity() {
    var mobileno: EditText? = null
    var message: EditText? = null
    var sendsms: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mobileno = findViewById<View>(R.id.editText1) as EditText
        message = findViewById<View>(R.id.editTextPassword) as EditText
        sendsms = findViewById<View>(R.id.button1) as ImageButton
        sendsms!!.setOnClickListener {
            val no = mobileno!!.text.toString()
            val msg = message!!.text.toString()
            val intent = Intent(applicationContext, MainActivity::class.java)
            val pi = PendingIntent.getActivity(applicationContext, 0, intent, 0)
            val sms = SmsManager.getDefault()
            sms.sendTextMessage(no, null, msg, pi, null)
            Toast.makeText(applicationContext, "Message Sent successfully!",
                    Toast.LENGTH_LONG).show()
        }
    }
}