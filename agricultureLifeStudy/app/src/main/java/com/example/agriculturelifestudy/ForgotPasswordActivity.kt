package com.example.agriculturelifestudy


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

/*In this activity, we will send the email and the mobile number to the server.
 Kindly use the registered email and mobile number only, otherwise the OTP won't be sent to your email id.
 The received OTP will be valid for next 24 hours and you will not receive more than one email per day*/

/*Once the OTP is shared to you on your registered email id, you can then send it along with the mobile number\
* and the new password. The mobile number can be stored in an intent and sent to the next activity from here itself*/

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var etForgotMobile: EditText
    lateinit var etForgotEmail: EditText
    lateinit var btnForgotNext: Button
    lateinit var progressBar: ProgressBar
    lateinit var rlContentMain: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etForgotMobile = findViewById(R.id.etForgotMobile)
        etForgotEmail = findViewById(R.id.etForgotEmail)
        btnForgotNext = findViewById(R.id.btnForgotNext)
        rlContentMain = findViewById(R.id.rlContentMain)
        progressBar = findViewById(R.id.progressBar)
        rlContentMain.visibility = View.VISIBLE
        progressBar.visibility = View.GONE


        btnForgotNext.setOnClickListener {

        }


    }
}
