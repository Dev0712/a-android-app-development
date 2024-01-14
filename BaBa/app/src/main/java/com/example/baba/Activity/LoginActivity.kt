package com.example.baba.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.baba.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var registerYourself: TextView

    val validMobileNumber="8302571961"
    val validPassword="dev"

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intent = Intent(this@LoginActivity, MainActivity::class.java)

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        registerYourself = findViewById(R.id.txtRegister)



        /*Handling the clicks using the setOnClickListener method*/
        txtForgotPassword.setOnClickListener {


            Toast.makeText(
                this@LoginActivity,
                "forgot password",
                Toast.LENGTH_LONG
            ).show()
        }
        registerYourself.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

            Toast.makeText(
                this@LoginActivity,
                "register yourself",
                Toast.LENGTH_LONG
            ).show()


        }

        btnLogin.setOnClickListener {
            val MobileNumber = etMobileNumber.text.toString()

            val Password = etPassword.text.toString()


            if ((MobileNumber == validMobileNumber) && (Password == validPassword) )
            {
                startActivity (intent)
            }
            else
            {
                Toast.makeText(
                    this@LoginActivity,
                    "Incorrect credentials",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}