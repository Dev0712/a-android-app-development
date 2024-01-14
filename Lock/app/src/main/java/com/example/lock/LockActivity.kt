package com.example.lock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton

class LockActivity : AppCompatActivity() {

    lateinit var btnpinmethod : RadioButton
    lateinit var btnqamethod : RadioButton
    lateinit var btnsmsmethod : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)

        btnpinmethod = findViewById(R.id.btnpinmethod)
        btnqamethod = findViewById(R.id.btnqamethod)
        btnsmsmethod = findViewById(R.id.btnsmsmethod)





        btnpinmethod.setOnClickListener {
            startActivity(Intent(this@LockActivity, LockOptainActivity::class.java))
        }

        btnqamethod.setOnClickListener {
            startActivity(Intent(this@LockActivity, LockOptainActivity::class.java))
        }

        btnsmsmethod.setOnClickListener {
            startActivity(Intent(this@LockActivity, LockOptainActivity::class.java))
        }


    }
}