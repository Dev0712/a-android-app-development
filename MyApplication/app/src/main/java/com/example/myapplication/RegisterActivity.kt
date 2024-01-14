package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etName: EditText
    lateinit var btnRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etMobileNumber = findViewById(R.id.etPhoneNumber)
        etName = findViewById(R.id.etName)
        btnRegister = findViewById(R.id.btnRegister)


        btnRegister.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)

            Toast.makeText(this@RegisterActivity, "Register Successfully", Toast.LENGTH_LONG).show()
            intent.putExtra("Name",etName.text.toString())
            intent.putExtra("MobileNumber",etMobileNumber.text.toString())

            startActivity(intent)


        }

    }
}

