package com.example.baba.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.baba.R

class RegisterActivity : AppCompatActivity()
{
    lateinit var etMobileNumber: EditText
    lateinit var etName: EditText
    lateinit var etEmail: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}