package com.example.agriculturelifestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var titleName:String? = "Person"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent != null)
        {
            titleName = intent.getStringExtra("Name")
        }
        title = titleName
    }
}
