package com.example.agriculturelifestudy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {

        lateinit var etMobileNumber:EditText
        lateinit var etPassword:EditText
        lateinit var etName:EditText
        lateinit var btnLogin:Button
        lateinit var txtForgotPassword:TextView
        lateinit var txtRegister:TextView

    val validMobileNumber="8302571961"
    val validPassword="Dev@0712"
    val validName= arrayOf("Devendra","Narendra","jyoti","maya","Ramji lal raiger")

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val intent = Intent(this@LoginActivity, MainActivity::class.java)

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        etName=findViewById(R.id.etName)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {
            val MobileNumber = etMobileNumber.text.toString()

            val Password = etPassword.text.toString()

            val PersonName = etName.text.toString()


            if ((MobileNumber == validMobileNumber) && (Password == validPassword) && (validName.contains(
                    PersonName
                ))
            ) {
                intent.putExtra("Name", PersonName)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Incorrect credentials",
                    Toast.LENGTH_LONG
                ).show()

            }
        }

        txtForgotPassword.setOnClickListener {

            Toast.makeText(
                this@LoginActivity,
                "clicked on forgot wassword",
                Toast.LENGTH_LONG
            ).show()

            startActivity(Intent(this@LoginActivity,ForgotPasswordActivity::class.java))
        }

        txtRegister.setOnClickListener {

            Toast.makeText(
                this@LoginActivity,
                "clicked on Register",
                Toast.LENGTH_LONG
            ).show()

            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }


        startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}